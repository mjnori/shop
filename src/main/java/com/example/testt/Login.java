package com.example.testt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session=request.getSession(false);
        String username=(String)session.getAttribute("username");
        request.setAttribute("username",username);
//        response.setContentType("text/html");
//        PrintWriter out=response.getWriter();
//        out.println("Wellcome " + username);
        RequestDispatcher dispatcher=request.getRequestDispatcher("wellcome.jsp");
        dispatcher.forward(request,response);



    }
}
