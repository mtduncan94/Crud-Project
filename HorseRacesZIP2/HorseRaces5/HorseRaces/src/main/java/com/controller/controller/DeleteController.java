package com.controller;

import com.dao.RaceDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteRace(HttpServletRequest request) {
        dao.deleteRace(Integer.parseInt(request.getParameter("ID")));
        return new ModelAndView("redirect:/");
    }
}
