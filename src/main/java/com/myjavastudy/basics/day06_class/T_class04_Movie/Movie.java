package com.myjavastudy.basics.day06_class.T_class04_Movie;

public class Movie {
    String name , director;
    String[] str = new String[100];

    public void show(){
        System.out.println("电影名称为：" + name + "\n导演为：" + director + "\n演员有：" );
        for(int i = 0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }


}
