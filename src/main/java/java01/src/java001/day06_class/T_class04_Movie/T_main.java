package java001.day06_class.T_class04_Movie;

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
