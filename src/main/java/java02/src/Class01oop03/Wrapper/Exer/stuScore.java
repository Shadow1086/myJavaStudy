package Class01oop03.Wrapper.Exer;

import java.util.Vector;
import java.util.Scanner;

/**
 * ClassName: stuScore
 * Description:
 * 
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），
 * 找出最高分，并输出学生成绩等级。
 * 
 * 1、创建Vector对象：Vector v=new Vector();
 * 2、给向量添加元素：v.addElement(Object obj); //obj必须是对象
 * 3、取出向量中的元素：Object obj = v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 4、计算向量的长度：v.size();
 * 5、若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等
 * 
 * {@code @Author} Liang-ht
 * {@code @Create} 2025-10-14 22:04:18
 * {@code @Version} 1.0
 */
public class stuScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector vector = new Vector<>();
        float maxScore = 0;
        // 获得乘积信息并存储至数组中
        while (true) {
            System.out.print("请输入学生成绩：");
            float score = input.nextFloat();
            if (score < 0) {
                break;
            }
            // 获得乘积最大值
            if (maxScore < score) {
                maxScore = score;
            }
            // vector.addElement(String.valueOf(score));
            vector.addElement(score);
        }
        // 依次获得学生乘积，与最高分进行比较，获取学生等级并输出
        for (int i = 0; i < vector.size(); i++) {
            Object object = vector.elementAt(i);
            // 自动拆箱
            float score = (Float) object;
            char grade;
            if (maxScore - score < 10) {
                grade = 'A';
            } else if (maxScore - score < 20) {
                grade = 'B';
            } else if (maxScore - score < 30) {
                grade = 'C';
            } else {
                grade = 'D';
            }
            System.out.println("Student " + i + " score is " + score + " grade is " + grade);
        }
    }

}
