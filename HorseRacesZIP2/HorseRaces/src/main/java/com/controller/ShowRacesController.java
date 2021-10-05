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

        out.write("<html><h1>All Races</h1><table>");
        out.write("<tr><th><input type='text' name='ID' id='itemIdTitle' value='ID' readonly /></th>");
        out.write(
                "<th><input type='text' name='Race Name' id='Race Name' value='Race Name' readonly /></th>");
        out.write("<th><input type='text' name='Track Name' id='Track Name' value='Track Name' readonly /></th>");
        out.write("<th><input type='text' name='Race Date' id='Race Date' value='Race Date' readonly /></th></tr>");

        for (RaceDetails rd : allRaces) {

            out.write(
                    "<tr><td><input type='text' name='itemId' id='itemId' value='" + rd.getID() + "'/></td>");
            out.write("<td><input type='text' name='description' id='description' value='"
                    + rd.getRaceName() + "'/></td>");
            out.write("<td><input type='text' name='description' id='description' value='"
                    + rd.getTrackName() + "'/></td>");
            out.write("<td><input type='text' name='length' id='length' value='" + rd.getRaceDate() + "'/></td>");
            out.write("</tr>");
        }
        out.write("</table></form>");
        out.write("<form action = 'index.jsp'><input type='submit' value= 'Go Home' /></form></html>");

    }

}
