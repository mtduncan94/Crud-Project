package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetByIDController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request,ModelAndView model) throws IOException {
    
          int id = Integer.parseInt(request.getParameter("ID"));
           RaceDetails rd = dao.getRace(Integer.parseInt(request.getParameter("ID")));
              model.addObject("rd", rd);
         model.setViewName("DetailView");
        return  model;
    }

}
