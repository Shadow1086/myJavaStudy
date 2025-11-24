package com.myjavastudy.b_oop.class08_interface.Interface.Exer02;

/**
 * ClassName: ComparableCircle
 * Package: Class08.Interface.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 15:48
 * {@code @Version} 1.0
 */

/**
 * 若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 */
public class ComparableCircle extends Circle implements CompareObject{
    @Override
    public int compareTo(Object object){
        if(object instanceof Circle circle){
            if(circle.getRadius()>this.getRadius()) return -1;
            else if (circle.getRadius()<this.getRadius())   return 1;
            else if(circle.getRadius()==this.getRadius())   return 0;
        }
        return -100;
    }
}
