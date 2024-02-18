package com.t.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.util.JsonVos;
import com.t.jk.pojo.result.CodeMsg;
import com.t.jk.pojo.vo.JsonVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.function.Function;

/**
 * ClassName: BaseController
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 22:49
 * @Version: 1.0
 */
@Validated
public abstract class BaseController<Po, ReqVo> {

    protected abstract IService<Po> getService();
    protected abstract Function<ReqVo, Po> getFunction();

    @PostMapping("/remove")
    @ApiOperation("删除一条或多条数据")
    public JsonVo remove(
            @ApiParam(value = "一个或多个id，多个id用逗号拼接", required = true)
            @NotBlank(message = "id不 能为空")
            @RequestParam
            String id) {
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
            return JsonVos.ok(CodeMsg.REMOVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.REMOVE_ERROR);
        }
    }

    @PostMapping("/save")
    @ApiOperation("添加或更新")
    public JsonVo save(@Valid ReqVo reqVo) {
        Po po = getFunction().apply(reqVo);
        if (getService().saveOrUpdate(po)) {
            return JsonVos.ok(CodeMsg.SAVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
