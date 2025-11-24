package com.myjavastudy.b_oop.class08_interface.Interface.Exer03;

/**
 * ClassName: DeveloperTest
 * Package: Class08.Interface.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:38
 * {@code @Version} 1.0
 */

public class DeveloperTest {
    public static void main(String[] args) {
        Developer developer = new Developer("ali",20);

        Vehicle[] arr = new Vehicle[3];
        arr[0] = new Car("奔驰","白","1223456");
        arr[1] = new Bicycle("捷安特","黑");
        arr[2] = new ElectricVehicle("雅迪","白");

        for(Vehicle vehicle:arr){
            developer.takingVehicle(vehicle);
            if(vehicle instanceof IPower iPower){
                iPower.power();
            }
        }

    }

}
