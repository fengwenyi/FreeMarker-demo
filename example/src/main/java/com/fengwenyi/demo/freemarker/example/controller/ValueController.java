package com.fengwenyi.demo.freemarker.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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

    @RequestMapping("/calculate")
    public String calculate(ModelMap map){

        map.put("x", 34);
        map.put("y", 12);
        map.put("z", -12.5);
        map.put("w", 11.4);
        map.put("T", true);
        map.put("F", false);

        return "/calculate";
    }

    @RequestMapping("/obj")
    public ModelAndView obj() {
        ModelAndView mv = new ModelAndView("obj");
        User user = new User(1L, "张三", 20);
        mv.addObject("user", user);

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(Long.valueOf(i), "张" + i, (int) (Math.random() * 100)));
        }
        mv.addObject("list", userList);

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        mv.addObject("map", map);

        return mv;
    }

}
