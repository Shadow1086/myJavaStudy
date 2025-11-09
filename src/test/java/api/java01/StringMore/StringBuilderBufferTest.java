package api.java01.StringMore;

import org.junit.Test;

/**
 * ClassName: StringBuilderBufferTest
 * Description: 
 * 
 * （1）StringBuffer append(xx)：提供了很多的append()方法，用于进行字符串追加的方式拼接
        （2）StringBuffer delete(int start, int end)：删除[start,end)之间字符
        （3）StringBuffer deleteCharAt(int index)：删除[index]位置字符
        （4）StringBuffer replace(int start, int end, String str)：替换[start,end)范围的字符序列为str
        （5）void setCharAt(int index, char c)：替换[index]位置字符
        （6）char charAt(int index)：查找指定index位置上的字符
        （7）StringBuffer insert(int index, xx)：在[index]位置插入xx
        （8）int length()：返回存储的字符数据的长度
        （9）StringBuffer reverse()：反转
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-11-07 23:09:09
 */
public class StringBuilderBufferTest {
    @Test
    public void test01(){
        StringBuffer str1 = new StringBuffer();
        str1.append("abc").append("123");//方法链的调用
        System.out.println(str1);
    }
    @Test
    public void test02(){
        StringBuilder str = new StringBuilder("Hello");
        str.setLength(2);
        System.out.println(str);
        str.append("is");
        System.out.println(str);
    }
}
