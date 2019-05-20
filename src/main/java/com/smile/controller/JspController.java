package com.smile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController  {

    @RequestMapping(value = "/smile")
    public String smile(){
        return "smile";
    }
}
