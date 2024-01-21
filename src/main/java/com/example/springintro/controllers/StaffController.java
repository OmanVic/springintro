package com.example.springintro.controllers;

import com.example.springintro.entity.Staff;
import com.example.springintro.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/Staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView Home(){
        String info = "Welcome to Staff Information Database";
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

        List<Staff> staffList = staffService.getAllStaff();

        modelAndView.setViewName("staff/list");
        modelAndView.addObject("staffs", staffList);
        return modelAndView;
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public ModelAndView Register(@RequestParam(value="na") String name, @RequestParam(value = "ag") int age){
        staffService.CreateStaff(name, age);
        return List();
    }

    @RequestMapping(value = "/View", method = RequestMethod.GET)
    public ModelAndView View(@RequestParam(value = "id") Long id){

        Staff staff = staffService.getStaff(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff/view");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

    @RequestMapping(value = "/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "id") Long id){

        Staff staff = staffService.getStaff(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staff/edit");
        modelAndView.addObject("staff", staff);
        return modelAndView;
    }

    @RequestMapping(value = "/Update/{id}", method = RequestMethod.POST)
    public ModelAndView update( Staff staff, @PathVariable(value = "id") Long id){
        staff.setId(id);
        staffService.updateStaff(staff);
        return List();
    }

    @GetMapping(value = "/Delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        staffService.deleteStaff(id);
        List();
        System.out.println("this works");
        return List();
    }

}
