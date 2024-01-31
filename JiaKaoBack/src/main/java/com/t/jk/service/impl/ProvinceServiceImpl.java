package com.t.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.mapper.ProvinceMapper;
import com.t.jk.pojo.po.Province;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("provinceService")
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Autowired
    ProvinceMapper mapper;

    @Override
    public void list(ProvinceQuery query) {

        // 查询条件
        LambdaQueryWrapper<Province> wrapper = new LambdaQueryWrapper<>();
        String keyword = query.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.like(Province::getName, keyword).or()
                    .like(Province::getPlate, keyword).or();
        }

        // 按照id降序
        wrapper.orderByDesc(Province::getId);

        mapper.selectPage(new MpPage<Province>(query), wrapper).updateQuery(query);
    }

}

