package com.akihi.serendipity.admin.controller;

import com.akihi.serendipity.admin.api.domain.SysUser;
import com.akihi.serendipity.admin.service.SysUserService;
import com.akihi.serendipity.common.core.util.R;
import com.akihi.serendipity.common.core.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public R<?> save(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return R.ok(sysUser);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public R<?> remove(@PathVariable String userId) {
        SysUser sysUser = sysUserService.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id: " + userId));
        sysUser.setDeleted(true);
        sysUserService.save(sysUser);
        return R.ok();
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public R<?> update(@PathVariable String userId, @RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return R.ok();
    }


    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public R<SysUser> details(@PathVariable String userId) {
        return R.ok(sysUserService.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id: " + userId)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public R<List<SysUser>> list() {
        return R.ok(sysUserService.findAll());
    }


}
