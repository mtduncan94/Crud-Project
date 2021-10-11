package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowRacesController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/")
    public ModelAndView showRaces(ModelAndView model) throws IOException, SQLException {

        List<RaceDetails> raceList = dao.showAll();
        model.addObject("raceList", raceList);
        model.setViewName("index");
        return model;
    }

}
