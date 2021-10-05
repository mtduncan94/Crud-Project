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

        out.write("<html><h1>Showing Races For ID: " + id + "</h1><table>");
        out.write("<tr><th><input type='text' name='ID' id='itemIdTitle' value='ID' readonly /></th>");
        out.write(
                "<th><input type='text' name='Race Name' id='Race Name' value='Race Name' readonly /></th>");
        out.write("<th><input type='text' name='Track Name' id='Track Name' value='Track Name' readonly /></th>");
        out.write("<th><input type='text' name='Race Date' id='Race Date' value='Race Date' readonly /></th></tr>");
        out.write(
                "<tr><td><input type='text' name='itemId' id='itemId' value='" + id + "'/></td>");
        out.write("<td><input type='text' name='description' id='description' value='"
                + rd.getRaceName() + "'/></td>");
        out.write("<td><input type='text' name='description' id='description' value='"
                + rd.getTrackName() + "'/></td>");
        out.write("<td><input type='text' name='length' id='length' value='" + rd.getRaceDate() + "'/></td>");
        out.write("</tr>");
        out.write("</table></form></html>");
    }

}
