package com.dy.service;

import com.dy.domain.Book;
import com.dy.utils.SqlHelper;

import java.util.ArrayList;

//这是一个业务逻辑类 处理有关书籍的业务
public class BookService {

    //利用id号查询书籍
    public Book getBookById(String id){
        Book book=new Book();
        String sql="select * from book where id=?";
        String paras[]={id};
        ArrayList al=new SqlHelper().executeQuery(sql,paras);
        if(al.size()==1){
            Object object[]= (Object[]) al.get(0);
            book.setId(Integer.parseInt(object[0].toString()));
            book.setBookname(object[1].toString());
            book.setAuthor(object[2].toString());
            book.setPublishhouse(object[3].toString());
            book.setPrice(Float.parseFloat(object[4].toString()));
            book.setRepertory(Integer.parseInt(object[5].toString()));
        }
        return book;
    }

    public ArrayList getAllBook(){
        String sql="select * from book where 1=?";
        String paras[]={"1"};
        ArrayList al=new SqlHelper().executeQuery(sql,paras);
        ArrayList<Book> newAl=new ArrayList<Book>();
        //二次封装
        for (int i=0;i<al.size();i++){
            Object object[]= (Object[]) al.get(i);
            Book book=new Book();
            book.setId(Integer.parseInt(object[0].toString()));
            book.setBookname(object[1].toString());
            book.setAuthor(object[2].toString());
            book.setPublishhouse(object[3].toString());
            book.setPrice(Float.parseFloat(object[4].toString()));
            book.setRepertory(Integer.parseInt(object[5].toString()));
            newAl.add(book);
        }
        return newAl;
    }
}
