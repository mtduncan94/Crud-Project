package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaveController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/save")
    public ModelAndView saveRace(@ModelAttribute RaceDetails rd) {
        dao.addOrEdit(rd);
        return new ModelAndView("redirect:/");
    }

}
