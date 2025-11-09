package com.myjavastudy.oop.class08_interface.Interface.Exer02;

/**
 * ClassName: CompareRectangle
 * Package: Class08.Interface.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:14
 * {@code @Version} 1.0
 */

public class CompareRectangle extends Rectangle implements CompareObject{
    public CompareRectangle(double length, double weight) {
        super(length, weight);
    }

    @Override
    public int compareTo(Object object){
        if(object instanceof Rectangle rectangle){
                if(rectangle.findArea()>this.findArea()) return -1;
                else if (rectangle.findArea()<this.findArea())   return 1;
                else if(rectangle.findArea()==this.findArea())   return 0;
        }
        return -100;
    }

}
