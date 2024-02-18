package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.common.mapStruct.MapStructs;
import com.t.jk.mapper.ExamPlaceCourseMapper;
import com.t.jk.pojo.po.ExamPlaceCourse;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.ExamPlaceCourseVo;
import com.t.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.t.jk.service.ExamPlaceCourseService;
import org.springframework.stereotype.Service;

@Service("examPlaceCourseService")
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {

    /**
     * 这里需要返回的时候数据的类型是ExamPlaceCourseDto，但是这里的泛型是ExamPlaceCourse
     *
     * @param query
     */
    @Override
    public PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query) {

        MpQueryWrapper<ExamPlaceCourse> wrapper = new MpQueryWrapper<>();

        return baseMapper
                .selectPage(new MpPage<>(query), wrapper)
                .buildVo(MapStructs.INSTANCE::po2vo);

    }
}

