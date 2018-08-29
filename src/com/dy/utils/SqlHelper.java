package com.dy.utils;

import java.sql.*;
import java.util.ArrayList;

public class SqlHelper {
    private Connection ct=null;
    private ResultSet rs=null;
    private PreparedStatement ps=null;

    public ArrayList executeQuery(String sql,String parameters[]){
        ArrayList al = new ArrayList();
        DBUtil dbu=new DBUtil();
        try{
            ct = dbu.getConnection();
            ps = ct.prepareStatement(sql);
            for(int i=0;i<parameters.length;i++){
                ps.setString(i+1,parameters[i]);
            }
            rs=ps.executeQuery();
            //通过rsmd可以得到结果集有多少列
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnNum=rsmd.getColumnCount();
            while(rs.next()){
                Object objects[] = new Object[columnNum];
                for (int i = 0; i < objects.length; i++) {
                    objects[i]=rs.getObject(i+1);
                }
                al.add(objects);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            dbu.close(rs,ps,ct);
        }
        return al;

    }


}
