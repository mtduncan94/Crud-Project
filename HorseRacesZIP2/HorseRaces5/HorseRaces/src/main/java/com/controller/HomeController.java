
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping("/home")
    ModelAndView goHome(ModelAndView model){
        return new ModelAndView("redirect:/");
    }
}
