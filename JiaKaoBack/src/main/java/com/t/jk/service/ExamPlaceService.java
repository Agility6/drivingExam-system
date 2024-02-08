package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.ExamPlace;
import com.t.jk.pojo.query.ExamPlaceQuery;

public interface ExamPlaceService extends IService<ExamPlace> {

    void list(ExamPlaceQuery query);
}

