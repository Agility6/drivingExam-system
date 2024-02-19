package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.SysRoleResourceMapper;
import com.t.jk.pojo.po.SysRoleResource;
import com.t.jk.service.SysRoleResourceService;
import org.springframework.stereotype.Service;

@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements SysRoleResourceService {

}

