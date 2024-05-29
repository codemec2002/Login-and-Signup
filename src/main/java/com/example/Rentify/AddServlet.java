package com.example.Rentify;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k = i + j;
        System.out.println("result" + k);

//        req.setAttribute("k", k);
//        PrintWriter out = res.getWriter();
//        out.println("result is " + k);

        // call servlet from servlet
        // one way is request Dispatcher
        // Second way is Redirect

//        RequestDispatcher rd = req.getRequestDispatcher("sq");
//        rd.forward(req, res);

        // session management for sending data from one servlet to another servlet

        // redirect method use when two servlet are on different website
//        res.sendRedirect("sq?k="+k);    // ?k=+k is URL rewriting


//        HttpSession session = req.getSession();
//        session.setAttribute("k", k);

        Cookie cookie = new Cookie("k", k + "");
        res.addCookie(cookie);

        res.sendRedirect("sq");


    }

}
