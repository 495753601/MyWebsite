package com.xjl.learn.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-11-03-9:23
 */
@RestController
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/common/hello",method = RequestMethod.POST)
    public String hello(){
        return "hello";
    }

}
