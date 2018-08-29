package com.dy.service;

import com.dy.domain.*;
import com.dy.utils.SqlHelper;

import java.util.ArrayList;

//service用来处理业务逻辑
//此类专门用来处理有关users的业务逻辑
public class UsersService {
    public boolean checkUser(Users user){
        String sql="select * from users where id=? and password=?";
        String parameter[]={user.getId()+"",user.getPassword()};
        ArrayList al=new SqlHelper().executeQuery(sql,parameter);
        if(al.size()==0){
            return false;
        }else{
            Object []objects= (Object[]) al.get(0);
            user.setEmail((String) objects[3]);
            user.setUsername((String) objects[1]);
            user.setGrade(Integer.parseInt(objects[5].toString()));
            return true;
        }
    }
}
