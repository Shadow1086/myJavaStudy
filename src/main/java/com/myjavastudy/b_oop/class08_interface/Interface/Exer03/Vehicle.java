package com.myjavastudy.b_oop.class08_interface.Interface.Exer03;

/**
 * ClassName: Vehicle
 * Package: Class08.Interface.Exer03
 * Description:
 *
 * 阿里的一个工程师Developer,结构见图。
 *
 * 其中，有一个乘坐交通工具的方法takingVehicle()，在此方法中调用交通工具的run()。
 * 为了出行方便，他买了一辆捷安特自行车、一辆雅迪电动车和一辆奔驰轿车。这里涉及到的相关类及接口关系如图。
 *
 * 其中，电动车增加动力的方式是充电，轿车增加动力的方式是加油。在具体交通工具的run()中调用其所在类
 * 的相关属性信息。
 *
 * 请编写相关代码，并测试。
 *
 * 提示：创建Vehicle[]数组，保存阿里工程师的三辆交通工具，并分别在工程师的takingVehicle()中调用。
 *
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:23
 * {@code @Version} 1.0
 */

public abstract class Vehicle {
    private String brand;
    private String color;

    public Vehicle() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void run();
}

