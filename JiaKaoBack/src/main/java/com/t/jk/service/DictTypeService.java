package com.t.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.query.DictTypeQuery;

import java.util.List;

public interface DictTypeService extends IService<DictType> {

    void list(DictTypeQuery query);
}

