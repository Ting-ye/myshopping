package com.dy.controller;

import com.dy.domain.Book;
import com.dy.domain.Users;
import com.dy.service.BookService;
import com.dy.service.MyCart;
import com.dy.service.UsersService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GohallUI extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        //先判断用户是否登录 可读性比较差
        if(request.getSession().getAttribute("loginUser")!=null){
            // 先给写一个页面书籍的数据
            BookService bookService=new BookService();
            ArrayList al=bookService.getAllBook();
            //把数据放在request里面是因为request生命周期是最短的
            request.setAttribute("booksInfo",al);

            request.getRequestDispatcher("/WEB-INF/shoppingHall.jsp").forward(request,response);
            return;
        }

        String id=request.getParameter("id");
        String password=request.getParameter("password");

        Users loginUser=new Users(Integer.parseInt(id),password);
        UsersService usersService=new UsersService();
        if(usersService.checkUser(loginUser)){
            //表示用户id与密码正确 跳转到购物大厅页面
            //把用户信息存放到session
            request.getSession().setAttribute("loginUser",loginUser);

            //创建购物车
            MyCart myCart=new MyCart();
            request.getSession().setAttribute("myCart",myCart);

            // 先给写一个页面书籍的数据
            BookService bookService=new BookService();
            ArrayList al=bookService.getAllBook();
            //把数据放在request里面是因为request生命周期是最短的
            request.setAttribute("booksInfo",al);

            request.getRequestDispatcher("/WEB-INF/shoppingHall.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }
}
