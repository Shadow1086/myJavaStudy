package java001.day06.T_calss_Movie;

import java.util.Scanner;
import java.util.Arrays;

public class T_main {
    public static void main(String[] args) {
        Movie a = new Movie();
        a.name = "abcx";
        a.director = "xiaoihua";
        a.str = new String[]{
                "1","2","3"
        };
        a.show();
    }
}
