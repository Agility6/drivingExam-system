package com.t.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.util.Rs;
import com.t.jk.pojo.result.CodeMsg;
import com.t.jk.pojo.result.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

/**
 * ClassName: BaseController
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 22:49
 * @Version: 1.0
 */
@Validated
public abstract class BaseController<T> {

    protected abstract IService<T> getService();

    @PostMapping("/remove")
    @ApiOperation("删除一条或多条数据")
    public R remove(
            @ApiParam(value = "一个或多个id，多个id用逗号拼接", required = true)
            @NotBlank(message = "id不 能为空")
            @RequestParam
            String id) {
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
            return Rs.ok(CodeMsg.REMOVE_OK);
        } else {
            return Rs.raise(CodeMsg.REMOVE_ERROR);
        }
    }

    @PostMapping("/save")
    @ApiOperation("添加或更新")
    public R save(@Valid T entity) {
        if (getService().saveOrUpdate(entity)) {
            return Rs.ok(CodeMsg.SAVE_OK);
        } else {
            return Rs.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
