package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.dto.ProvinceDto;
import com.t.jk.pojo.po.PlateRegion;
import com.t.jk.pojo.query.CityQuery;
import com.t.jk.pojo.query.ProvinceQuery;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {

    void listProvinces(ProvinceQuery query);

    void listCities(CityQuery query);

    List<PlateRegion> listProvinces();

    List<ProvinceDto> listRegions();
}

