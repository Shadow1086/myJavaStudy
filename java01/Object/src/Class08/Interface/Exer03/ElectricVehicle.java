package Class08.Interface.Exer03;

/**
 * ClassName: ElectricVehicle
 * Package: Class08.Interface.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:24
 * {@code @Version} 1.0
 */
public class ElectricVehicle extends Vehicle implements IPower{
    public ElectricVehicle(String brand,String color) {
        this.setBrand(brand);
        this.setColor(color);
    }
    @Override
    public void run(){
        System.out.printf("ElectricVehicle{brand = %s , color = %s}%n",getBrand(),getColor());
    }
    @Override
    public void power(){
        System.out.println("ElectricVehicle's power is charging");
    }
}
