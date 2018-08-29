package com.dy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private  static Connection ct=null;
    private  PreparedStatement ps=null;
    private  ResultSet rs=null;

    private static String url="";
    private static String username="";
    private static String password="";
    private static String driver="";

    private static Properties properties=null;
    private static InputStream inputStream=null;

    static {
        try {

             properties=new Properties();
             inputStream=DBUtil.class.getClassLoader().getResourceAsStream("com/dy/utils/db.properties");
            try {
                properties.load(inputStream);
                driver=properties.getProperty("driver");
                username=properties.getProperty("username");
                url=properties.getProperty("url");
                password=properties.getProperty("password");
                Class.forName(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputStream=null;
        }
    }
    //得到连接
    public static Connection getConnection()
    {
        try
        //建立连接
        {ct = DriverManager.getConnection(url,username,password);}
        catch(Exception e) {e.printStackTrace();}
        return ct;
    }

    //关闭资源
    public static void close(ResultSet rs,Statement ps, Connection con){

        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
