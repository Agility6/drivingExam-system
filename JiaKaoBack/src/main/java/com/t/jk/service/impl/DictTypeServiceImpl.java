package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.mapper.DictTypeMapper;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.query.DictTypeQuery;
import com.t.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("dictTypeService")
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    private DictTypeMapper mapper;


    @Override
    public void list(DictTypeQuery query) {

        // enhance封装的方法
        // MpPage<DictType> page = new MpPage<>(query);

        // 查询条件
        MpQueryWrapper<DictType> wrapper = new MpQueryWrapper<>();
        String keyword = query.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(DictType::getName, keyword).or()
                    .like(DictType::getValue, keyword).or()
                    .like(DictType::getIntro, keyword);
        }
        // 按照id降序
        wrapper.orderByDesc(DictType::getId);

        // 返回值类型就是MpPage
        // 分页查询
        mapper.selectPage(new MpPage<>(query), wrapper).updateQuery(query);


    }
}

