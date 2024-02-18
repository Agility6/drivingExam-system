package com.t.jk.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("区域")
public class PlateRegionVo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称【不能为空】")
    private String name;

    @ApiModelProperty("车牌【车牌的长度只能是1，比如粤、A、B等】")
    private String plate;

    @ApiModelProperty("父区域id")
    private Integer parentId;
}

