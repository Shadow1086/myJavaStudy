package Class01.Varargs;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:n个字符串进行拼接，每一个字符串之间使用某字符进行分割
 * 如果没有传入字符串，那么返回空字符串
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/28 10:27
 * {@code @Version} 1.0
 */

public class Varargs {
    static String returnString(String str1,String... str){
        String result = "";
        for(int i = 0;i<str.length;i++){
            if(i!= 0)   result += str1;
            result += str[i];

        }
        return  result;
    }
    public static void main(String[] args) {
        System.out.println(returnString("-"));
        System.out.println(returnString("-","abc"));
        System.out.println(returnString("-","abc","def"));

    }
}
