package com.t.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.DictTypeMapper;
import com.t.jk.pojo.po.DictType;
import com.t.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("dictTypeService")
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    private DictTypeMapper mapper;


    @Override
    public IPage<DictType> list(long page, long size, String keyword) {

        Page<DictType> mpPage = new Page<>(page, size);
        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(DictType::getName, keyword).or()
                    .like(DictType::getValue, keyword).or()
                    .like(DictType::getIntro, keyword);
        }

        // 按照id降序
        wrapper.orderByDesc(DictType::getId);
        return mapper.selectPage(mpPage, wrapper);
    }
}

