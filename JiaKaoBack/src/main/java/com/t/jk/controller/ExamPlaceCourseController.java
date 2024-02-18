package com.t.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.mapStruct.MapStructs;
import com.t.jk.common.util.JsonVos;
import com.t.jk.pojo.po.ExamPlaceCourse;
import com.t.jk.pojo.vo.PageJsonVo;
import com.t.jk.pojo.vo.list.ExamPlaceCourseVo;
import com.t.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.t.jk.pojo.vo.req.save.ExamPlaceCourseReqVo;
import com.t.jk.service.ExamPlaceCourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/examPlaceCourses")
public class ExamPlaceCourseController extends BaseController<ExamPlaceCourse, ExamPlaceCourseReqVo> {

    @Autowired
    ExamPlaceCourseService service;

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query) {
        return JsonVos.ok(service.list(query));
    }

    @Override
    protected IService<ExamPlaceCourse> getService() {
        return service;
    }

    @Override
    protected Function<ExamPlaceCourseReqVo, ExamPlaceCourse> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }
}

