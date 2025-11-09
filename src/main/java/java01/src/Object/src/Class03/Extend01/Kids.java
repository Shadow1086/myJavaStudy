package Class03.Extend01;

/**
 * ClassName: Practice01
 * Package: Class03.Extend01
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/2 16:33
 * {@code @Version} 1.0
 */

public class Kids extends Mankind {
    private int yearsOld;

    public Kids(){}

    public Kids(int sex, int salary, int yearsOld) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println(yearsOld);
    }

}
