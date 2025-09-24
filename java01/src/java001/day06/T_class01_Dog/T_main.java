package java001.day06.T_class01_Dog;

public class T_main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "小黑";
        dog.age = 5;
        dog.sayHello();
        Dog dog2 = new Dog();
        dog2.name = "小白";
        dog2.age = 3;
        dog2.sayHello();
    }
}
