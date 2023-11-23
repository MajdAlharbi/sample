package relaxhouse_spa;

public abstract class Service implements Discount {

    //Properties
    private final int serviceNumber;
    private String SerName;
    private double price;
    private final double TAX = 0.15;

    //defult Constructer
    public Service() {
        this(0, "", 0.0);
    }

    //full Constructer
    public Service(int serviceNumber, String SerName, double price) {
        this.serviceNumber = serviceNumber;
        this.SerName = SerName;
        this.price = price;

    }

    //All Getter
    public int getServiceNumber() {
        return serviceNumber;
    }

    public String getSerName() {
        return SerName;
    }

    public double getPrice() {
        return price;
    }

    public double getTAX() {
        return TAX;
    }

    //All Setter
    public void setSerName(String SerName) {
        this.SerName = SerName;
    }

    public void setPrice(double price) {

    }

    //behavior
    public final double total(double price, double TAX) {
        return price * TAX;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("Service Number: %d\nService Name: %s\nPrice: %.2f SAR\nTAX: %.2f%%\n", getServiceNumber(), getSerName(), getPrice(), getTAX() * 100);
    }

}
