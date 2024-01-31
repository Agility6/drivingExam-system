package com.t.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.Province;

public interface ProvinceService extends IService<Province> {

    IPage<Province> list(long page, long size, String keyword);
}

