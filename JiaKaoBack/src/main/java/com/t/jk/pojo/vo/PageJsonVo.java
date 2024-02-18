package com.t.jk.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * ClassName: PageJsonVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/18 23:44
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageJsonVo<T> extends DataJsonVo<List<T>> {

    @ApiModelProperty("总数")
    private Long count;
}
