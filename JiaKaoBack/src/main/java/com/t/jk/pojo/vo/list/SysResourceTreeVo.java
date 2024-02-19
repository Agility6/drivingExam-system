package com.t.jk.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName: SysResourceTreeVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/19 16:38
 * @Version: 1.0
 */
@Data
@ApiModel("树状结构的资源")
public class SysResourceTreeVo {
    @ApiModelProperty("id")
    private Short id;

    @ApiModelProperty("名称")
    private String title;

    @ApiModelProperty("默认是否展开")
    private Boolean spread = true;

    @ApiModelProperty("子资源")
    private List<SysResourceTreeVo> children;
}