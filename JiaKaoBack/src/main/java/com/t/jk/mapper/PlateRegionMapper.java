package com.t.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.t.jk.pojo.vo.list.ProvinceVo;
import com.t.jk.pojo.po.PlateRegion;

import java.util.List;

public interface PlateRegionMapper extends BaseMapper<PlateRegion> {

    List<ProvinceVo> selectRegions();
}

