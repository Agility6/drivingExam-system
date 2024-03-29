package com.t.jk.pojo.po;

import com.t.jk.common.foreign.anno.ForeignField;
import lombok.Data;

@Data
public class SysRoleResource {

    //角色id
    @ForeignField(SysRole.class)
    private Short roleId;

    //资源id
    @ForeignField(SysResource.class)
    private Short resourceId;
}

