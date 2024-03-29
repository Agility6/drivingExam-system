package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpLambdaQueryWrapper;
import com.t.jk.common.mapStruct.MapStructs;
import com.t.jk.mapper.DictTypeMapper;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.DictTypeVo;
import com.t.jk.pojo.vo.req.page.DictTypePageReqVo;
import com.t.jk.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dictTypeService")
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictTypeVo> list(DictTypePageReqVo query) {

        // enhance封装的方法
        // MpPage<DictType> page = new MpPage<>(query);

        // 查询条件
        MpLambdaQueryWrapper<DictType> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.like(query.getKeyword(), DictType::getName, DictType::getValue, DictType::getIntro);

        // 按照id降序
        wrapper.orderByDesc(DictType::getId);

        // 返回值类型就是MpPage
        // 分页查询
        return baseMapper
                .selectPage(new MpPage<>(query), wrapper)
                .buildVo(MapStructs.INSTANCE::po2vo);

    }
}

