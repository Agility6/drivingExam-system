package com.t.jk.pojo.po;

import com.t.jk.common.foreign.anno.ForeignField;
import com.t.jk.common.validator.BoolNumber;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class DictItem {
    //主键
    private Integer id;
    //名称
    @NotBlank(message = "名称不能为空")
    private String name;

    //值
    @NotBlank(message = "值不能为空")
    private String value;

    //排列序号，默认0，值越大排越前面
    @Min(value = 0, message = "序号不能是负数")
    private Integer sn;

    //是否禁用，默认0不禁用
    @BoolNumber // 自定义校验
    private Short disabled;

    //所属类型
    @ForeignField(DictType.class)
    private Integer typeId;
}

