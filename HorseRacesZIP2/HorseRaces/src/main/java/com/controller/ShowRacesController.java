package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
