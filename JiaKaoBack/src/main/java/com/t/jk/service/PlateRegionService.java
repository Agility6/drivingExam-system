package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.PlateRegionVo;
import com.t.jk.pojo.vo.list.ProvinceVo;
import com.t.jk.pojo.po.PlateRegion;
import com.t.jk.pojo.vo.req.page.CityPageReqVo;
import com.t.jk.pojo.vo.req.page.ProvincePageReqVo;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {

    PageVo<PlateRegionVo> listProvinces(ProvincePageReqVo query);

    PageVo<PlateRegionVo> listCities(CityPageReqVo query);

    List<PlateRegionVo> listProvinces();

    List<ProvinceVo> listRegions();
}

