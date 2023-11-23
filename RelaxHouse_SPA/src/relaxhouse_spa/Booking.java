package relaxhouse_spa;

import java.util.Arrays;

public class Booking {

    //Properties
    protected final int BookingID;
    private Customer customer;
    private Date BookingDate;
    private Time Time;
    private Service[] services;

    //defult Constructer
    public Booking() {
        this(null, null, null, null);
    }

    //full Constructer
    public Booking(Customer customer, Date BookingDate, Time Time, Service[] services) {
        this.BookingID = (int) (10000 * Math.random() + 1);
        this.customer = customer;
        this.BookingDate = BookingDate;
        this.Time = Time;
        this.services = services;

    }

    //All Getter
    public int getBookingID() {
        return BookingID;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public Service[] getServices() {
        return services;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Time getTime() {
        return Time;
    }

    //All Setter
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBookingDate(Date BookingDate) {
        this.BookingDate = BookingDate;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    //behaviors
    public void displayServices() {
        for (Service s : services) {
            System.out.println(s);
            //method in interface
            if (s instanceof Hair) {
                ((Hair) s).prinHairStyles();
            }
        }
    }

    public double total() {
        double total = 0;
        for (Service s : services) {
            double price = s.getPrice();
            price -= price * s.discount();
            price += price * s.getTAX();
            total += price;
        }
        return total;
    }

    //toString
    @Override
    public String toString() {
        return String.format("Booking ID: %d\nCustomer: %s\nBooking Date: %s\nBooking Time: %s\nServices: %s\n", BookingID, customer, BookingDate, Time, Arrays.toString(getServices()));
    }
}
