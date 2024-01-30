package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.DictItemMapper;
import com.t.jk.pojo.po.DictItem;
import com.t.jk.service.DictItemService;
import org.springframework.stereotype.Service;

@Service("dictItemService")
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

}

