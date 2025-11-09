package Class08.Interface.Exer03;

/**
 * ClassName: Car
 * Package: Class08.Interface.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:24
 * {@code @Version} 1.0
 */
public class Car extends Vehicle implements IPower {
    private String carNumber;

    public Car(String brand, String color, String carNumber) {
        this.setBrand(brand);
        this.setColor(color);
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.printf("Car{brand = %s , color = %s , carNumber = %s}%n", getBrand(), getColor(), getCarNumber());
    }

    @Override
    public void power() {
        System.out.println("Car's power is gasoline");
    }
}
