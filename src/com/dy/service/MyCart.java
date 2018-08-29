package com.dy.service;

import com.dy.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//这个表示我的购物车
public class MyCart {
    HashMap<String,Book> hm=new HashMap<String,Book>();


    //添加书
    public  void addBook(String id,Book book){
        if(hm.containsKey(id)){
            Book book1=hm.get(id);
            Integer buybooknum=book1.getBuybooknum();
            book1.setBuybooknum(buybooknum+1);
            hm.put(id,book);
        }else{
            hm.put(id,book);
        }

    }
    //添加书 改进以后的方法
    public  void addBookBetter(String id){
        if(hm.containsKey(id)){
            Book bookAdd=hm.get(id);
            Integer buybooknum=bookAdd.getBuybooknum();
            bookAdd.setBuybooknum(buybooknum+1);
        }else{
            hm.put(id,new BookService().getBookById(id));
        }
    }

    //获得购买书籍的总价格
    public float getTotalBookPrice(){
        float totalBookPrice=0.0f;
        ArrayList<Book> arrayList=new ArrayList<Book>();

        Iterator iterator=hm.keySet().iterator();
        while (iterator.hasNext()){
            String bookId= (String) iterator.next();
            Book book=hm.get(bookId);

            totalBookPrice+=book.getPrice()*book.getBuybooknum();
        }
        return totalBookPrice;
    }

    //删除书
    public void delBook(String id){
        hm.remove(id);
    }

    //更新书
    public void updateBook(String id,String nums){
        //取出id对应的book
        Book bookupd=hm.get(id);
        bookupd.setBuybooknum(Integer.parseInt(nums));
    }

    //清空购物车
    public void clearBook(){
        hm.clear();
    }

    //把加入购物车的书籍添加到HashMap中 并遍历显示
    public ArrayList insertIntoMyCart(){
        ArrayList<Book> al=new ArrayList<Book>();
        Iterator iterator=hm.keySet().iterator();
        while(iterator.hasNext()){
            //取出key
            String id= (String) iterator.next();
            //取出Book
            Book book=hm.get(id);
            al.add(book);
        }
        return al;
    }

}
