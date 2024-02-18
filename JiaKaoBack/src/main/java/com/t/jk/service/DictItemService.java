package com.t.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.pojo.po.DictItem;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.DictItemVo;
import com.t.jk.pojo.vo.req.page.DictItemPageReqVo;


public interface DictItemService extends IService<DictItem> {

    PageVo<DictItemVo> list(DictItemPageReqVo query);
}

