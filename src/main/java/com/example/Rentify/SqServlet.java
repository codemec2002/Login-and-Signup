package com.example.Rentify;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SqServlet", value = "/sq")
public class SqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        int k = (int) request.getAttribute("k");
//        k *= k;

        PrintWriter out = response.getWriter();

//        int k = Integer.parseInt(request.getParameter("k"));

//        HttpSession session = request.getSession();
//        int k = (int) session.getAttribute("k");

        Cookie cookies[] = request.getCookies();
        int k = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("k")) {
                k = Integer.parseInt(cookie.getValue());
            }
        }

        k *= k;
        out.println("result is " + k);
        System.out.println("sq called");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
