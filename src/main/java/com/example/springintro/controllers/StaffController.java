package com.example.springintro.controllers;

import com.example.springintro.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView Home(){
        String info = "Welcome to Spring Boot";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff/index");
        modelAndView.addObject("info", info);
        return modelAndView;
    }

    @RequestMapping(value = "/Create", method = RequestMethod.GET)
    public ModelAndView Create(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff/create");

        return modelAndView;
    }

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public ModelAndView List(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff/list");
        return modelAndView;
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public ModelAndView Register(@RequestParam(value="na") String name, @RequestParam(value = "ag") int age){
        staffService.CreateStaff(name, age);
        return null;
    }
}
