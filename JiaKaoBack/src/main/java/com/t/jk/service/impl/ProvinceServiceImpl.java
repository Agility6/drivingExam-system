package com.t.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.ProvinceMapper;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.po.Province;
import com.t.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("provinceService")
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Autowired
    ProvinceMapper mapper;

    @Override
    public IPage<Province> list(long page, long size, String keyword) {

        Page<Province> mpPage = new Page<>(page, size);
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(Province::getName, keyword).or()
                    .like(Province::getPlate, keyword).or();
        }

        // 按照id降序
        wrapper.orderByDesc(Province::getId);

        return mapper.selectPage(mpPage, wrapper);
    }
}

