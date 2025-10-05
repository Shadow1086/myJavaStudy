package Class04.Exer06;

/**
 * ClassName: PersonTest
 * Package: Class04.Exer06
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 10:08
 * {@code @Version} 1.0
 */

public class PersonTest {
    /**
     * 在该方法中，每一个人先吃饭，然后上洗手间，然后如果是男人，随后抽根烟；如果是女人，随后化个妆
     * @param ps 人
     */
    public static void meeting(Person... ps){
        for(int i = 0 ;i<ps.length;i++){
            ps[i].eat();
            ps[i].toilet();

            if(ps[i] instanceof Man){
                ((Man)ps[i]).smoke();
            }else if(ps[i] instanceof Woman){
                ((Woman)ps[i]).makeup();
            }


        }
    }


}
