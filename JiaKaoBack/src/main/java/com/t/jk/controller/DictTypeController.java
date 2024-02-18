package com.t.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.mapStruct.MapStructs;
import com.t.jk.common.util.JsonVos;
import com.t.jk.common.util.Streams;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.vo.DataJsonVo;
import com.t.jk.pojo.vo.PageJsonVo;
import com.t.jk.pojo.vo.list.DictTypeVo;
import com.t.jk.pojo.vo.req.page.DictTypePageReqVo;
import com.t.jk.pojo.vo.req.save.DictTypeReqVo;
import com.t.jk.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;


@RestController
@RequestMapping("/dictTypes")
@Api(tags = "数据字典类型")
public class DictTypeController extends BaseController<DictType, DictTypeReqVo> {

    @Autowired
    public DictTypeService service;

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<DictTypeVo> list(DictTypePageReqVo query) {
        return JsonVos.ok(service.list(query));
    }

    /**
     * 返回列表所有数据
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询所有")
    public DataJsonVo<List<DictTypeVo>> list() {
       return JsonVos.ok(Streams.map(service.list(), MapStructs.INSTANCE::po2vo));
    }

    @Override
    protected IService<DictType> getService() {
        return service;
    }

    @Override
    protected Function<DictTypeReqVo, DictType> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

}

