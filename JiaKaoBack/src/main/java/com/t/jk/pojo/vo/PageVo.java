package com.t.jk.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName: PageVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/19 01:04
 * @Version: 1.0
 */

@ApiModel("分页结果")
@Data
public class PageVo<T> {

    @ApiModelProperty("总数")
    private Long count;

    @ApiModelProperty("总页数")
    private Long pages;

    @ApiModelProperty("数据")
    private List<T> data;
}
