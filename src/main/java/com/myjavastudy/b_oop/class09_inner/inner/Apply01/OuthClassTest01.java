package com.myjavastudy.b_oop.class09_inner.inner.Apply01;

public class OuthClassTest01 {
//说明：局部内部类的使用
    public void method1(){
        //局部内部类
        class A{
            //可以声明属性，方法等
        }
    }


    //开发中的场景
    public Comparable getInstance(){

//提供了实现了Comparable接口的类
        //方式一：提供了接口的实现类的匿名对象
        class MyComparable implements Comparable{
            @Override
            public int compareTo(Object object){
                return 0;
            }
        }
        return new MyComparable();
/*
 * 
 * //方式二：提供了接口的匿名实现类的有名对象
        Comparable comparable = new Comparable() {
             @Override
            public int compareTo(Object object){
                return 0;
            } 
        };
        return comparable;
 * 

        


        //方式三：提供了接口的匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object object){
                return 0;
            }
        };
        
*/
    }
}
