package com.t.jk.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.po.Province;
import com.t.jk.pojo.query.KeywordQuery;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.service.DictTypeService;
import com.t.jk.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService service;

    @GetMapping
    public Map<String, Object> list(ProvinceQuery query) {
        service.list(query);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", query.getCount());
        map.put("data", query.getData());
        return map;
    }

    /**
     *
     * @param id "1" 或者是 "1,2,3,4"
     * @return
     */
    @PostMapping("/remove")
    public Map<String, Object> remove(String id) {
        if (service.removeByIds(Arrays.asList(id.split(",")))) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            return map;
        } else {
            throw new RuntimeException("删除失败");
        }
    }

    @PostMapping("/save")
    public  Map<String, Object> save(Province province) {
        if (service.saveOrUpdate(province)) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "保存成功");
            return map;
        } else {
            throw new RuntimeException("保存失败");
        }
    }

}

