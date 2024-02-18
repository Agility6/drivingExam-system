package com.t.jk.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("数据字典条目")
public class DictItemVo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("值")
    private String value;

    @ApiModelProperty("序号")
    private Integer sn;

    @ApiModelProperty("是否禁用")
    private Short disabled;

    @ApiModelProperty(value = "数据字典类型的id")
    private Integer typeId;
}

