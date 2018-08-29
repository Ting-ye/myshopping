package com.dy.controller;

import com.dy.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GoMyOrderServlet")
//用于用户查看订单
public class GoMyOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        MyCart myCart= (MyCart) request.getSession().getAttribute("myCart");
        ArrayList al=myCart.insertIntoMyCart();
        float totalBookPrice=myCart.getTotalBookPrice();
        request.setAttribute("orderInfo",al);
        request.setAttribute("totalBookPrice",totalBookPrice);
        //跳转到我的订单页面
        request.getRequestDispatcher("/WEB-INF/myOrder.jsp").forward(request,response);
    }
}
