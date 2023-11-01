package com.akihi.serendipity.admin.service.impl;

import com.akihi.serendipity.admin.api.domain.SysUser;
import com.akihi.serendipity.admin.repository.SysUserRepository;
import com.akihi.serendipity.admin.service.SysUserService;
import com.akihi.serendipity.common.jpa.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public BaseRepository<SysUser, String> getRepository() {
        return this.sysUserRepository;
    }
}
