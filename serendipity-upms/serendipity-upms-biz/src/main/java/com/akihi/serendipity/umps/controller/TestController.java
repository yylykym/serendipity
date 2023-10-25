package com.akihi.serendipity.umps.controller;

import com.akihi.serendipity.common.core.R;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/resource")
public class TestController {
    @GetMapping("/res1")
    public ResponseEntity<R<String>> res1(){
        return ResponseEntity.internalServerError().body(R.ok());
    }



}
