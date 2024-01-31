package com.t.jk.controller;



import com.t.jk.common.util.Rs;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.query.DictTypeQuery;
import com.t.jk.pojo.result.R;
import com.t.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {

    @Autowired
    public DictTypeService service;

    @GetMapping
    public R list(DictTypeQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    /**
     *
     * @param id "1" 或者是 "1,2,3,4"
     * @return
     */
    @PostMapping("/remove")
    public R remove(String id) {
        if (service.removeByIds(Arrays.asList(id.split(",")))) {
            return Rs.ok("删除成功");
        } else {
            return Rs.error("删除失败");
        }
    }

    @PostMapping("/save")
    public R save(DictType dictType) {
        if (service.saveOrUpdate(dictType)) {
          return Rs.ok("保存成功");
        } else {
            return Rs.error("保存失败");
        }
    }
}

