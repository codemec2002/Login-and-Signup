package com.example.Rentify;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserRegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setUserEmail(email);
        user.setUserPassword(password);

        try {
            User registeredUser = userService.registerUser(user);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("User registered successfully with ID: " + registeredUser.getUserEmail());
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            response.getWriter().write("Email already exists");
        }
    }
}

