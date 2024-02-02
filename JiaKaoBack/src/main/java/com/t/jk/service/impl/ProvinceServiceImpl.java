package com.t.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.mapper.ProvinceMapper;
import com.t.jk.pojo.po.Province;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("provinceService")
@Transactional
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Override
    @Transactional(readOnly = true)
    public void list(ProvinceQuery query) {

        MpQueryWrapper<Province> wrapper = new MpQueryWrapper<>();
        wrapper.like(query.getKeyword(), Province::getName, Province::getPlate);
        // 按照id降序
        wrapper.orderByDesc(Province::getId);

        baseMapper.selectPage(new MpPage<Province>(query), wrapper).updateQuery();
    }

}

