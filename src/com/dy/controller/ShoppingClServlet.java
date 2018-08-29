package com.dy.controller;

import com.dy.service.BookService;
import com.dy.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingClServlet")
public class ShoppingClServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //接收type值区分 add del update
        String type=request.getParameter("type");
        if("add".equals(type)){
            String id=request.getParameter("id");
            //在GoHallUI控制器验证用户成功是创建购物车
            MyCart myCart= (MyCart) request.getSession().getAttribute("myCart");
            myCart.addBookBetter(id);
            //把书籍数据放入request准备显示
            request.setAttribute("bookListInCart",myCart.insertIntoMyCart());
            //计算书籍总价格
            request.setAttribute("totalBookPrice",myCart.getTotalBookPrice()+"");
            //显示我的购物车
            request.getRequestDispatcher("/WEB-INF/myCart.jsp").forward(request,response);
        }else if("del".equals(type)){
            //说明用户要删除书籍
            String id=request.getParameter("id");
            MyCart myCart= (MyCart) request.getSession().getAttribute("myCart");
            System.out.println("是否执行");
            myCart.delBook(id);
            //把书籍数据放入request准备显示
            request.setAttribute("bookListInCart",myCart.insertIntoMyCart());
            //计算书籍总价格
            request.setAttribute("totalBookPrice",myCart.getTotalBookPrice()+"");
            //显示我的购物车
            request.getRequestDispatcher("/WEB-INF/myCart.jsp").forward(request,response);
        }else if(type.equals("update")){
            //接收mycart页面表单传过来的商品id 和 商品数量
            String booksId[]=request.getParameterValues("id");
            String goodsNum[]=request.getParameterValues("goodsNum");
            //提出购物车
            MyCart myCart= (MyCart) request.getSession().getAttribute("myCart");
            for(int i=0;i<booksId.length;i++){
                myCart.updateBook(booksId[i],goodsNum[i]);
            }
            //把书籍数据放入request准备显示
            request.setAttribute("bookListInCart",myCart.insertIntoMyCart());
            //计算书籍总价格
            request.setAttribute("totalBookPrice",myCart.getTotalBookPrice()+"");
            //显示我的购物车
            request.getRequestDispatcher("/WEB-INF/myCart.jsp").forward(request,response);
        }

    }
}
