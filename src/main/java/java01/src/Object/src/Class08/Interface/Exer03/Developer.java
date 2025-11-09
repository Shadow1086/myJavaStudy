package Class08.Interface.Exer03;

/**
 * ClassName: Developer
 * Package: Class08.Interface.Exer03
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/11 16:36
 * {@code @Version} 1.0
 */

public class Developer {
    private String name;
    private int age;

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void takingVehicle(Vehicle vehicle){
        vehicle.run();
    }
}
