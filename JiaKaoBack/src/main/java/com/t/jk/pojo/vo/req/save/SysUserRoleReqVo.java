package com.t.jk.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SysUserRoleReqVo {

    @NotNull
    @ApiModelProperty(value = "角色id", required = true)
    private Short roleId;

    @NotNull
    @ApiModelProperty(value = "用户id", required = true)
    private Integer userId;
}

