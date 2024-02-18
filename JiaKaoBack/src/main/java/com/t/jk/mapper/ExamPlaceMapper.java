package com.t.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.t.jk.pojo.vo.list.ProvinceVo;
import com.t.jk.pojo.po.ExamPlace;

import java.util.List;

public interface ExamPlaceMapper extends BaseMapper<ExamPlace> {

    // xml编写sql语句
    List<ProvinceVo> selectRegionExamPlaces();
}

