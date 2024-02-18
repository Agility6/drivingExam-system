package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.DictType;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.DictTypeVo;
import com.t.jk.pojo.vo.req.page.DictTypePageReqVo;

public interface DictTypeService extends IService<DictType> {

    PageVo<DictTypeVo> list(DictTypePageReqVo query);
}

