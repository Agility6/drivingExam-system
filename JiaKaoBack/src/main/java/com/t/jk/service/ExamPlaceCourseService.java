package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.ExamPlaceCourse;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.ExamPlaceCourseVo;
import com.t.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;

public interface ExamPlaceCourseService extends IService<ExamPlaceCourse> {

    PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query);
}

