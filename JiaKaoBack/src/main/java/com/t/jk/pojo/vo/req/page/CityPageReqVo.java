package com.t.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: CityPageReqVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/2 17:12
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CityPageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("身份id")
    private Integer parentId;
}
