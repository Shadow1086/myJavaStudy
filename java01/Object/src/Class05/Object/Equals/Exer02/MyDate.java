package Class05.Object.Equals.Exer02;

/**
 * ClassName: MyDate
 * Package: Class05.Object.Equals.Exer02
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/10/5 12:20
 * {@code @Version} 1.0
 */

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof MyDate myDate) {
            return this.day == myDate.day && this.month == myDate.month && this.day == myDate.day;
        }
        return false;
    }
}
