package com.dy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {

    private FilterConfig filterConfig;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse) resp;
        HttpSession session = request.getSession();
        //利用过滤器参数设置字符集
        String charset=filterConfig.getInitParameter("charset");
        if(charset==null){
            charset="UTF-8";
        }
        request.setCharacterEncoding(charset);
        //接受web.xml中的参数进行匹配 带有相应参数的都放行
        String noLoginFilter=filterConfig.getInitParameter("noLoginFilter");
        if(noLoginFilter!=null){
            String[] strArray=noLoginFilter.split(";");
            for(int i=0;i<strArray.length;i++){
                if (strArray[i]==null||strArray[1].equals(""))continue;
                if(request.getRequestURL().indexOf(strArray[i])!=-1){
                    chain.doFilter(request,response);
                    return;
                }
            }

        }


        if(session.getAttribute("username")!=null){
            chain.doFilter(request,response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig=config;
    }

}
