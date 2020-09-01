package com.cxtx.demo;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {


    @RequestMapping(value = "helloWorld")
    public String helloWorld(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("name","Tom");
        mv.setViewName("fafaf.html");


        return "HelloWorld";
    }


}
