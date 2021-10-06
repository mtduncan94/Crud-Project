package com.controller;

import com.dao.RaceDAO;
import com.entity.RaceDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GetByIDController {

    @Autowired
    RaceDAO dao;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("ID"));
        RaceDetails rd = dao.getRace(id);
        PrintWriter out = response.getWriter();

        out.write("<html><style> body{ background-color: gray}"
                +"table, th, td {border: 3px solid black;cellpadding:5;}</style><h1>Showing Races For ID: " + id + "</h1><table>");
        out.write("<tr><th>ID</th>");
        out.write(
                "<th>Race Name</th>");
        out.write("<th>Track Name</th>");
        out.write("<th>Race Date</th></tr>");
        out.write(
                "<tr><td><input size = '7' type='text' name='itemId' id='itemId' value='" + id + "'/></td>");
        out.write("<td><input type='text' name='description' id='description' value='"
                + rd.getRaceName() + "'/></td>");
        out.write("<td><input type='text' name='description' id='description' value='"
                + rd.getTrackName() + "'/></td>");
        out.write("<td><input type='text' name='length' id='length' value='" + rd.getRaceDate() + "'/></td>");
        out.write("</tr>");
        out.write("</table></form><br><form action = 'index.jsp'><input type='submit' value= 'Go Home' /></form></html>");
    }

}
