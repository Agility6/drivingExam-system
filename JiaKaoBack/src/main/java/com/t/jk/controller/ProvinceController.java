package com.t.jk.controller;


import com.t.jk.common.util.Rs;
import com.t.jk.pojo.po.Province;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService service;

    @GetMapping
    public Map<String, Object> list(ProvinceQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    /**
     *
     * @param id "1" 或者是 "1,2,3,4"
     * @return
     */
    @PostMapping("/remove")
    public Map<String, Object> remove(String id) {
        if (service.removeByIds(Arrays.asList(id.split(",")))) {
            return Rs.error("删除成功");
        } else {
            return Rs.error("删除失败");
        }
    }

    @PostMapping("/save")
    public  Map<String, Object> save(Province province) {
        if (service.saveOrUpdate(province)) {
            return Rs.ok("保存成功");
        } else {
            return Rs.error("保存失败");
        }
    }

}

