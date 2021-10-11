package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView saveRace(@ModelAttribute RaceDetails rd ) {
        dao.addOrEdit(rd);
        return new ModelAndView("redirect:/");
    }

}
