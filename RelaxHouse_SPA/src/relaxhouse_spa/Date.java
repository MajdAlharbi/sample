package relaxhouse_spa;

public final class Date {

    //Properties
    private int day;
    private int month;
    private int year;

    //defult Constructer
    public Date() {
        this(0, 0, 0);
    }

    //full Constructer
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //All Getter
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    //All Setter
    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            this.day = 0;
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }
    }

    public void setYear(int year) {
        if (year >= 2023) {
            this.year = year;
        } else {
            this.year = 2023;
        }
    }

    //ToString
    @Override
    public String toString() {
        return String.format("%d/%d/%d \n", day, month, year);
    }

}
