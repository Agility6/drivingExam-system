package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.SysResourceMapper;
import com.t.jk.pojo.po.SysResource;
import com.t.jk.service.SysResourceService;
import org.springframework.stereotype.Service;

@Service("sysResourceService")
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

}

