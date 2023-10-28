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
        return ResponseEntity.ok(R.ok());
    }

    @GetMapping
    @com.akihi.serendipity.common.log.annotation.SysLog("1111")
    public ResponseEntity<R> test2() {


        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.internalServerError().body(R.ok(repository.findAll()));
    }



}
