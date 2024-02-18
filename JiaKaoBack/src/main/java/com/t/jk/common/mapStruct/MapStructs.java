package com.t.jk.common.mapStruct;

import com.t.jk.pojo.po.*;
import com.t.jk.pojo.vo.list.*;
import com.t.jk.pojo.vo.req.save.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: MapStructs
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/19 00:43
 * @Version: 1.0
 */
@Mapper
public interface MapStructs {

    MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

    /**
     * ReqVo -> Po
     * Po -> Vo
     */

    // po -> Vo
    DictItemVo po2vo(DictItem po);
    DictTypeVo po2vo(DictType po);
    ExamPlaceVo po2vo(ExamPlace po);
    PlateRegionVo po2vo(PlateRegion po);
    ExamPlaceCourseVo po2vo(ExamPlaceCourse po);

    // reqVo -> po
    DictItem reqVo2po(DictItemReqVo reqVo);
    DictType reqVo2po(DictTypeReqVo reqVo);
    ExamPlace reqVo2po(ExamPlaceReqVo reqVo);
    PlateRegion reqVo2po(PlateRegionReqVo reqVo);
    ExamPlaceCourse reqVo2po(ExamPlaceCourseReqVo reqVo);

}
