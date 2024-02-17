package com.t.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.util.Rs;
import com.t.jk.pojo.po.PlateRegion;
import com.t.jk.pojo.query.CityQuery;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.pojo.result.R;
import com.t.jk.service.PlateRegionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/plateRegions")
@Api(tags = "省份/城市")
public class PlateRegionController extends BaseController<PlateRegion> {

    @Autowired
    private PlateRegionService service;

    @GetMapping("/regions")
    public R listRegions() {
        return Rs.ok(service.listRegions());
    }

    @GetMapping("/provinces")
    public R listProvinces(ProvinceQuery query) {
        service.listProvinces(query);
        return Rs.ok(query);
    }

    @GetMapping("/provinces/list")
    public R listProvinces() {
        return Rs.ok(service.listProvinces());
    }

    @GetMapping("/cities")
    public R listCities(CityQuery query) {
        service.listCities(query);
        return Rs.ok(query);
    }

    @Override
    protected IService<PlateRegion> getService() {
        return service;
    }
}

