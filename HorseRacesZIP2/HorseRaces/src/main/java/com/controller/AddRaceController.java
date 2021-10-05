package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddRaceController {

    @Autowired
    RaceDAO dao;

    @RequestMapping("/addrace")
    public ModelAndView addRace(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String raceName = request.getParameter("raceName");
        String trackName = request.getParameter("trackName");
        String raceDate = request.getParameter("date");

        RaceDetails rd = new RaceDetails(0, raceName, trackName, raceDate);
        dao.addRace(rd);

        return new ModelAndView("redirect:/show");
    }

}
