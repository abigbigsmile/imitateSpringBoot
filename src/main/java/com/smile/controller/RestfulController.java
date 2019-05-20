package com.smile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @RequestMapping(value = "/index", produces = "text/htmml;charset=UTF-8")
    public String index(){
        return "成功手写模拟Springboot.";
    }
}
