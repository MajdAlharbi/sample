package relaxhouse_spa;

public final class MassageServices extends Service {

    //Properties
    private String MassageServiceType;

    //defult Constructer
    public MassageServices() {
        this("", 0, "", 0.0);
    }

    //full Constructer
    public MassageServices(String MassageServiceType, int serviceNumber, String SerName, double price) {
        super(serviceNumber, SerName, price);
        this.MassageServiceType = MassageServiceType;
    }

    //All Getter
    public String getMassageServiceType() {
        return MassageServiceType;
    }

    public static double getMAX_DISCOUNT() {
        return MAX_DISCOUNT;
    }

    //All Setter
    public void setMassageServiceType(String MassageServiceType) {
        this.MassageServiceType = MassageServiceType;
    }

    //behavior
    @Override
    public double discount() {
        return 0.05;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("\n**Massage**\n%s\n%s\n", super.toString(),getMassageServiceType());
    }

}
