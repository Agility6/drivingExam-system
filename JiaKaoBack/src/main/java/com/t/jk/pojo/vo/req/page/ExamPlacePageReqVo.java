package com.t.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: ExamPlacePageReqVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/6 16:44
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlacePageReqVo extends KeywordPageReqVo {

    @ApiModelProperty("身份id")
    private Integer provinceId;

    @ApiModelProperty("城市id")
    private Integer cityId;
}
