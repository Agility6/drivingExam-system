package com.t.jk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.DictType;

import java.util.List;

public interface DictTypeService extends IService<DictType> {

    IPage<DictType> list(long page, long size, String keyword);
}

