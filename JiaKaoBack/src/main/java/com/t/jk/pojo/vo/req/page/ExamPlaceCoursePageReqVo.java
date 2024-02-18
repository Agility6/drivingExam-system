package com.t.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: ExamPlaceCoursePageReqVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/18 20:15
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlaceCoursePageReqVo extends KeywordPageReqVo {

    @ApiModelProperty("课程类型【0是课程集合，2是科目二，3是科目三】")
    private Short type;

    @ApiModelProperty("身份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("考场id")
    private Integer placeId;
}
