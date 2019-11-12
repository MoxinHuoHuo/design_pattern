package com.moxin.design_pattern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 17:03
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/foodTemplate")
    public String test1() {
        return "food template test !!!!";
    }

}
