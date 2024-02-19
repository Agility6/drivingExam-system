package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.mapper.SysUserMapper;
import com.t.jk.pojo.po.SysUser;
import com.t.jk.service.SysUserService;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}

