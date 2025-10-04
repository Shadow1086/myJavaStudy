package Class04.Exer01;

/**
 * ClassName: Practice01
 * Package: Class04.Exer01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/4 21:04
 * {@code @Version} 1.0
 */

public class PersonTest02 {
    public static void main(String[] args) {
        Person p1= new Man();
        //子类对象的特有方法不能被直接调用。
        // p1.earnMoney();

        //向下转型：
        Man m1 = (Man) p1;
        m1.earnMoney();
        //p1 m1指向堆空间的同一对象
        System.out.println(p1 == m1);

//向下转型可能会出现：
    //类型转换异常:ClassCastException
        Person p2 = new Women();
//        Man m2 = (Man)p2;
//        m2.earnMoney();

        //建议在向下转型之前，使用instanceof进行判断，避免出现类型转换异常
        //格式： a instanceof A :判断对象a是否是类A的实例。
        //如果a instanceof A 返回true，则：
        //          a instanceof superA  返回也是true，其中 A是SuperA的子类。
        if(p2 instanceof Man){
            Man m2 = (Man)p2;
            m2.earnMoney();
        }

    }

}
