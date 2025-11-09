package com.myjavastudy.oop.class08_interface.Interface.Exer03;

/**
 * ClassName: Bicycle
 * Package: Class08.Interface.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:24
 * {@code @Version} 1.0
 */
public class Bicycle extends Vehicle{
    public Bicycle() {
    }
    public Bicycle(String brand,String color){
        this.setBrand(brand);
        this.setColor(color);
    }
    @Override
    public void run(){
        System.out.printf("Bicycle{brand = %s , color = %s}%n",getBrand(),getColor());
    }
}
