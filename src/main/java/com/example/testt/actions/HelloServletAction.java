package com.example.testt.actions;

import com.example.testt.forms.LoginForm;
import com.example.testt.model.Customer;
import com.example.testt.shop.Shop;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
//import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServletAction extends DispatchAction {

    Shop shop = new Shop();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm=(LoginForm) form;
//        loginForm.setNoCustomer(false);
//        loginForm.setNickName("mj");
//        loginForm.setPassword("123456");
         loginForm.setMessage("this is a test");
        return mapping.findForward("show");
    }
    public ActionForward register(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        LoginForm loginForm=(LoginForm) form;

        String username = loginForm.getNickName();
        String password = loginForm.getPassword();

        Customer customer = new Customer(username, password);

            if (!shop.isExistingCustomer(customer)) {
                shop.addCustomer(customer);
                System.out.println("user is added");
                String message = "user is added";
                loginForm.setMessage(message);
                request.setAttribute("message", message);
            } else {
                System.out.println("user is duplicate");
                String message = "user is duplicate";
                loginForm.setMessage(message);
                request.setAttribute("message", message);
            }
//            request.setAttribute("username", username);
//            request.setAttribute("password", password);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");


        return  mapping.findForward("show");
    } // End of Register Method


    public ActionForward login (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        LoginForm loginForm=(LoginForm) form;

        String username = loginForm.getNickName();
        String password = loginForm.getPassword();

        Customer customer = new Customer(username, password);

        if (shop.isExistingCustomer(customer)) {
                  request.setAttribute("username", username);
//                HttpSession session=request.getSession();
//                session.setAttribute("username",username);
//                session.setAttribute("password",password);
//                response.sendRedirect("login");
//                RequestDispatcher dispatcher=request.getRequestDispatcher("/login");
//                dispatcher.forward(request, response);
               return mapping.findForward("wellcome");


//                RequestDispatcher dispatcher = request.getRequestDispatcher("wellcome.jsp");
//
            } else {

                String message = "there is no such user!!!";
                request.setAttribute("message", message);
                return mapping.findForward("show");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//                dispatcher.forward(request, response);

            }
//
    }

//    public
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//        dispatcher.forward(request, response);
//    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String button = request.getParameter("button");


        Customer customer = new Customer(username, password);
        if (button.equalsIgnoreCase("register")) {
            if (!shop.isExistingCustomer(customer)) {
                shop.addCustomer(customer);
                System.out.println("user is added");
                String message = "user is added";
                request.setAttribute("message", message);
            } else {
                System.out.println("user is duplicate");
                String message = "user is duplicate";
                request.setAttribute("message", message);
            }
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }

        if (button.equalsIgnoreCase("login")) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            if (shop.isExistingCustomer(customer)) {
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("password",password);
//                response.sendRedirect("login");
                RequestDispatcher dispatcher=request.getRequestDispatcher("/login");
                dispatcher.forward(request, response);


//                RequestDispatcher dispatcher = request.getRequestDispatcher("wellcome.jsp");
//
            } else {

                String message = "there is no such user!!!";
                request.setAttribute("message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);

            }
//
        }

    }

    public void destroy() {
    }
}