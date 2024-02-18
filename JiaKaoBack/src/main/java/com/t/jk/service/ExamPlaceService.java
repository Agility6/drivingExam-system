package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.ExamPlaceVo;
import com.t.jk.pojo.vo.list.ProvinceVo;
import com.t.jk.pojo.po.ExamPlace;
import com.t.jk.pojo.vo.req.page.ExamPlacePageReqVo;

import java.util.List;

public interface ExamPlaceService extends IService<ExamPlace> {

    PageVo<ExamPlaceVo> list(ExamPlacePageReqVo query);

    List<ProvinceVo> listRegionExamPlaces();
}

