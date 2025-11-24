package com.myjavastudy.b_oop.class08_interface.Interface.Apply02;

/**
 * ClassName: Camera
 * Package: Class08.Interface.Apply02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 11:40
 * {@code @Version} 1.0
 */

public class Camera implements USB{
    @Override
    public void start(){
        System.out.println("照相机开始工作");
    }

    @Override
    public void stop(){
        System.out.println("照相机结束工作");
    }

}
