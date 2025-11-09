package com.myjavastudy.oop.class01_basics.Encapsulation.Encapsulation03;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:定义book类，声明属性
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 14:07
 * {@code @Version} 1.0
 */

public class Book {
    //属性
    private String bookName;
    private String author;
    private int price;
    //方法：

    public void setBookName(String name) {
        bookName = name;
    }
    public String getBookName(){
        return bookName;
    }

    public void setAuthor(String name) {
        author = name;
    }
    public String getAuthor(){
        return author;
    }

    public void setPrice(int num){
        if(num>0){
            price = num;
        }else {
            System.out.println("输入数据错误");
        }

    }
    public int getPrice(){
        return price;
    }
}
