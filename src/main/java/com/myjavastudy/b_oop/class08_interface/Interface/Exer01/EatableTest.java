package com.myjavastudy.b_oop.class08_interface.Interface.Exer01;

/**
 * ClassName: EatableTest
 * Package: Class08.Interface.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 12:03
 * {@code @Version} 1.0
 */
public class EatableTest {
    public static void main(String[] args) {
        Eatable[] arr = new Eatable[3];
        arr[0] = new Chinese();
        arr[1] =new American();
        arr[2] = new Indian();
        for(Eatable eatable: arr){
            eatable.eat();
        }
    }
}
