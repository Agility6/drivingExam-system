package com.t.jk.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.DictTypeMapper;
import com.t.jk.pojo.po.DictType;
import com.t.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictTypeService")
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    private DictTypeMapper mapper;


    @Override
    public IPage<DictType> list(long page, long limit) {
        Page<DictType> mpPage = new Page<>(page, limit);
        return mapper.selectPage(mpPage, null);
    }
}

