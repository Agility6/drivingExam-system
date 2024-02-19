package com.t.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.pojo.po.ExamPlaceCourse;
import com.t.jk.pojo.vo.list.ExamPlaceCourseVo;
import org.apache.ibatis.annotations.Param;

public interface ExamPlaceCourseMapper extends BaseMapper<ExamPlaceCourse> {

    /**
     * 自定义分页查询
     * @param page
     * @param wrapper
     * @return
     */
    MpPage<ExamPlaceCourseVo> selectPageVos(MpPage<ExamPlaceCourseVo> page,
                                         @Param(Constants.WRAPPER) MpQueryWrapper<ExamPlaceCourseVo> wrapper);
}

