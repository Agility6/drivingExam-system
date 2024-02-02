package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.mapper.DictTypeMapper;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.query.DictTypeQuery;
import com.t.jk.service.DictTypeService;
import org.springframework.stereotype.Service;

@Service("dictTypeService")
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    public void list(DictTypeQuery query) {

        // enhance封装的方法
        // MpPage<DictType> page = new MpPage<>(query);

        // 查询条件
        MpQueryWrapper<DictType> wrapper = new MpQueryWrapper<>();
        wrapper.like(query.getKeyword(), DictType::getName, DictType::getValue, DictType::getIntro);

        // 按照id降序
        wrapper.orderByDesc(DictType::getId);

        // 返回值类型就是MpPage
        // 分页查询
        baseMapper.selectPage(new MpPage<>(query), wrapper).updateQuery();


    }
}

