package com.akihi.serendipity.admin.controller;

import com.akihi.serendipity.admin.api.domain.SysLog;
import com.akihi.serendipity.common.core.R;
import com.akihi.serendipity.admin.repository.SysLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class TestController {

    @Autowired
    private SysLogRepository repository;
    @PostMapping
    public ResponseEntity<R<String>> res1(@RequestBody SysLog log){

        repository.save(log);
        return ResponseEntity.internalServerError().body(R.ok());
    }

    @GetMapping
    public ResponseEntity<R> test2() {
        int i = 1 / 0;
        return ResponseEntity.ok(R.ok(repository.findAll()));
    }



}
