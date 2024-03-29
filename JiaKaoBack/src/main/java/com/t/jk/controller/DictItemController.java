package com.t.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.mapStruct.MapStructs;
import com.t.jk.common.util.JsonVos;
import com.t.jk.pojo.po.DictItem;
import com.t.jk.pojo.vo.PageJsonVo;
import com.t.jk.pojo.vo.list.DictItemVo;
import com.t.jk.pojo.vo.req.page.DictItemPageReqVo;
import com.t.jk.pojo.vo.req.save.DictItemReqVo;
import com.t.jk.service.DictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;


@RestController
@RequestMapping("/dictItems")
@Api(tags = "数据字典条目")
public class DictItemController extends BaseController<DictItem, DictItemReqVo>{

    @Autowired
    public DictItemService service;

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<DictItemVo> list(DictItemPageReqVo query) {
        return JsonVos.ok(service.list(query));
    }

    @Override
    protected IService<DictItem> getService() {
        return service;
    }

    @Override
    protected Function<DictItemReqVo, DictItem> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

}

