package com.t.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.util.Rs;
import com.t.jk.pojo.po.DictItem;
import com.t.jk.pojo.query.DictItemQuery;
import com.t.jk.pojo.result.R;
import com.t.jk.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem>{

    @Autowired
    public DictItemService service;

    @GetMapping
    public R list(DictItemQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    @Override
    protected IService<DictItem> getService() {
        return service;
    }

}

