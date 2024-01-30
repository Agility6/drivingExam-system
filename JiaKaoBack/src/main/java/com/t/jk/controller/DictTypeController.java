package com.t.jk.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.t.jk.pojo.po.DictType;
import com.t.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {

    @Autowired
    public DictTypeService service;

    @GetMapping
    public Map<String, Object> list(long page, long limit) {
        IPage<DictType> types = service.list(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", types.getTotal());
        map.put("data", types.getRecords());
        return map;
    }
}

