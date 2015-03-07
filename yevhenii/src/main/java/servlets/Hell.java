package servlets;

import shop.Good;
import shop.db_access.DBgood;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by eugene on 22.02.15.
 */
public class Hell extends HttpServlet{
    private String message;

    public void init() throws ServletException {
String s = new DBgood().selectAll().toString();
        Good g = new Good();
        String[] strings = s.split("\\W");
        String l = null;
        String temp;
        for (int i = 0; i <strings.length ; i++) {
            temp = strings[i];
            l = temp +" " + l;

        }
            message = l;
        }



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}

