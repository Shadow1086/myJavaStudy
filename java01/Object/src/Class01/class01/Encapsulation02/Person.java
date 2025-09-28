package Class01.class01.Encapsulation02;

class Person {
    //属性
    private int age;

    //方法
    //设置
    public void setAge(int num) {
        if (num > 0 && num < 120) {
            age = num;
        } else {
            System.out.println("输入数据有误");
        }
    }

    //读取
    public int getAge() {
        return age;
    }
}