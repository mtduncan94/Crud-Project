package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView editRace(HttpServletRequest request) {
       int id = Integer.parseInt(request.getParameter("ID"));
       RaceDetails rd = dao.getRace(id);
       ModelAndView model = new ModelAndView("RaceForm");
        model.addObject("rd",rd);
        return model;
    }
}
