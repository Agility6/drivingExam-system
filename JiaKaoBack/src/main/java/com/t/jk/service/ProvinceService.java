package com.t.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.Province;
import com.t.jk.pojo.query.KeywordQuery;
import com.t.jk.pojo.query.ProvinceQuery;

public interface ProvinceService extends IService<Province> {

    void list(ProvinceQuery query);
}

