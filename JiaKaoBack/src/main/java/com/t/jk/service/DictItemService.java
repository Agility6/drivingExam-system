package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.DictItem;
import com.t.jk.pojo.query.DictItemQuery;

import java.util.List;


public interface DictItemService extends IService<DictItem> {

    void list(DictItemQuery query);
}

