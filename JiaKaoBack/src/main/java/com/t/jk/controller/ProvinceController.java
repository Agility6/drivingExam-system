package com.t.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.util.Rs;
import com.t.jk.pojo.po.Province;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/provinces")
public class ProvinceController extends BaseController<Province> {

    @Autowired
    private ProvinceService service;

    @GetMapping
    public Map<String, Object> list(ProvinceQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    @Override
    protected IService<Province> getService() {
        return service;
    }

}
