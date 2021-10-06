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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowRacesController {

    @Autowired
    RaceDAO dao;

    @RequestMapping("/show")
    public void showRaces(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws IOException, SQLException {

        List<RaceDetails> allRaces = dao.showAll();
        PrintWriter out = response.getWriter();

        out.write("<html><style> body{ background-color: gray}"
                +"table, th, td {border: 3px solid black;cellpadding:5;}</style> <h1>All Races</h1><table>");
        out.write("<tr><th>ID</th>");
        out.write("<th>Race Name</th>");
        out.write("<th>Track Name</th>");
        out.write("<th>Race Date</th></tr>");

        for (RaceDetails rd : allRaces) {

            out.write(
                    "<tr><td><input size = '7' type='text' name='itemId' id='itemId' value='" + rd.getID() + "'/></td>");
            out.write("<td><input type='text' name='description' id='description' value='"
                    + rd.getRaceName() + "'/></td>");
            out.write("<td><input type='text' name='description' id='description' value='"
                    + rd.getTrackName() + "'/></td>");
            out.write("<td><input type='text' name='length' id='length' value='" + rd.getRaceDate() + "'/></td>");
            out.write("</tr>");
        }
        out.write("</table></form>");
        out.write("<br><form action = 'index.jsp'><input type='submit' value= 'Go Home' /></form></html>");

    }

}
