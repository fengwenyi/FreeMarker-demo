package com.fengwenyi.demo.freemarker.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author Wenyi Feng
 */
@Controller
@RequestMapping("/value")
public class ValueController {

    @GetMapping("/get")
    public ModelAndView getValue() {
        ModelAndView mv = new ModelAndView("get-value");
        mv.addObject("intVar", 100);
        mv.addObject("longVar", 100000000000000L);
        mv.addObject("stringVar", "我是字符串");
        mv.addObject("doubleVar", Math.PI);
//        mv.addObject("doubleVar", 3.14);
//        mv.addObject("doubleVar", 3.1415D);
        mv.addObject("booleanVar", Boolean.TRUE);
        mv.addObject("dateUtilVar", new Date());
        mv.addObject("dateSqlVar", new java.sql.Date(new Date().getTime()));
        mv.addObject("nullVar", null);
        return mv;
    }

}
