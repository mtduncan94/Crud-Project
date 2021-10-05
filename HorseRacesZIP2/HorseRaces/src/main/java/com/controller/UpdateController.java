package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/update")
    ModelAndView updateRace(HttpServletRequest request) {
        RaceDetails rd = new RaceDetails(Integer.parseInt(request.getParameter("ID")), request.getParameter("raceName"), request.getParameter("trackName"), request.getParameter("date"));
        dao.updateRace(rd);
        return new ModelAndView("redirect:/show");
    }
}
