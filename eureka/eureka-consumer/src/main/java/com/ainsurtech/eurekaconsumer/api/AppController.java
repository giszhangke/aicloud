package com.ainsurtech.eurekaconsumer.api;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;


@Controller
public class AppController {
    @Autowired
    private Client client;

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public @ResponseBody
    String showLoginPage(ModelMap model) throws RestClientException, IOException {
        return client.getEmployee("/process");
    }
}