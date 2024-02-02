package com.t.jk.controller;



import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.util.Rs;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.query.DictTypeQuery;
import com.t.jk.pojo.result.R;
import com.t.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dictTypes")
public class DictTypeController extends BaseController<DictType> {

    @Autowired
    public DictTypeService service;

    @GetMapping
    public R list(DictTypeQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    /**
     * 返回列表所有数据
     * @return
     */
    @GetMapping("/list")
    public R list() {
        return Rs.ok(service.list());
    }

    @Override
    protected IService getService() {
        return service;
    }

}

