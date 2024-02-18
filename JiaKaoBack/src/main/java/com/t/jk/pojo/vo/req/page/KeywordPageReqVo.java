package com.t.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: KeywordPageReqVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 14:59
 * @Version: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordPageReqVo extends PageReqVo {

    @ApiModelProperty("搜索关键字")
    private String keyword;
}
