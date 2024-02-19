package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.mapper.ExamPlaceCourseMapper;
import com.t.jk.pojo.po.ExamPlaceCourse;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.ExamPlaceCourseVo;
import com.t.jk.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.t.jk.service.ExamPlaceCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("examPlaceCourseService")
@Transactional
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {

    /**
     * 这里需要返回的时候数据的类型是ExamPlaceCourseDto，但是这里的泛型是ExamPlaceCourse
     *
     * @param query
     */
    @Override
    @Transactional(readOnly = true)
    public PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo query) {

        /**
         * 首先，用于lambda cache的实体类Entity，才能使用LambdaQueryWrapper<Entity>,
         * 默认情况下，只有BaseMapper<Entity>中的Entity类，才拥有lambda cache
         * 其他类需要通过TableInfoHelper手动添加lambda cache
         */
        MpQueryWrapper<ExamPlaceCourseVo> wrapper = new MpQueryWrapper<>();

        Integer placeId = query.getPlaceId();
        Integer provinceId = query.getProvinceId();
        Integer cityId = query.getCityId();
        Short type = query.getType();

        // 类型
        if (type != null && type >= 0) {
            wrapper.eq("c.type", type);
        }
        // 考场 -> 城市 -> 省份
        if (placeId != null && placeId > 0) {
            wrapper.eq("c.place_id", placeId);
        } else if (cityId != null && cityId > 0) {
            wrapper.eq("p.city_id", cityId);
        } else if (provinceId != null && provinceId > 0) {
            wrapper.eq("p.province_id", provinceId);
        }

        // 关键词
        wrapper.like(query.getKeyword(), "c.name", "c.intro");
        return baseMapper
                .selectPageVos(new MpPage<>(query), wrapper)
                .buildVo();
    }
}

