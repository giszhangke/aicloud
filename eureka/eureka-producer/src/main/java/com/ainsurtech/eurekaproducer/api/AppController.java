package com.ainsurtech.eurekaproducer.api;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @RequestMapping(value="/process", method = RequestMethod.GET)
    public @ResponseBody String  showLoginPage(ModelMap model){
        return "Processing app";
    }
}