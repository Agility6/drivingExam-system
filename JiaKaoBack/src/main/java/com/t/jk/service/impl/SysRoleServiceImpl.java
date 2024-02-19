package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.SysRoleMapper;
import com.t.jk.pojo.po.SysRole;
import com.t.jk.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}

