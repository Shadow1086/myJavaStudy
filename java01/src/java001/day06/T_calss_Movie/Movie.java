package java001.day06.T_calss_Movie;

import java.util.Scanner;
import java.util.Arrays;

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
