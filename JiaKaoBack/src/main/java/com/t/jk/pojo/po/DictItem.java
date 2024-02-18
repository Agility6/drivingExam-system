package com.t.jk.pojo.po;

import com.t.jk.common.foreign.anno.ForeignField;
import lombok.Data;


@Data
public class DictItem {

    //主键
    private Integer id;

    //名称
    private String name;

    //值
    private String value;

    //排列序号，默认0，值越大排越前面
    private Integer sn;

    //是否禁用，默认0不禁用
    private Short disabled;

    //所属类型
    @ForeignField(DictType.class)
    private Integer typeId;
}

