package com.akihi.serendipity.admin.service;

import com.akihi.serendipity.admin.api.domain.SysUser;
import com.akihi.serendipity.common.jpa.repository.BaseRepository;
import com.akihi.serendipity.common.jpa.service.WriteableService;

public interface SysUserService extends WriteableService<SysUser, String> {
    @Override
    BaseRepository<SysUser, String> getRepository();
}
