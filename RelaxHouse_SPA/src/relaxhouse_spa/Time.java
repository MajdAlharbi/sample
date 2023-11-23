package relaxhouse_spa;

public final class Time {

    //Properties
    private double hours;
    private double minutes;

    //defult Constructer
    public Time() {
        this(0, 0);
    }

    //full Constructer
    public Time(double hours, double minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    //All Getter
    public double getHours() {
        return hours;
    }

    public double getMinutes() {
        return minutes;
    }

    //All Setter
    public void setHours(double hours) {
        if (hours >= 0 && hours <= 23) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
    }

    public void setMinutes(double minutes) {
        if (minutes >= 0 && minutes <= 59) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    //ToString
    @Override
    public String toString() {
        return String.format("%.0f:%.0f \n", hours, minutes);
    }

}
