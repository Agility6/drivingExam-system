package com.t.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: DictItemPageReqVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 22:36
 * @Version: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemPageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("数据字典类型的id")
    private Integer typeId;

}
