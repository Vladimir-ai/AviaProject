package org.example.backend.controllers.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UtilController {
    @RequestMapping(method = RequestMethod.GET, path = "/docs")
    public String docs(){
        return "redirect:/swagger-ui.html";
    }
}
