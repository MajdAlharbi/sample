package relaxhouse_spa;

public final class NailCare extends Service {

    //Properties
    private String NailCareServiceType;

    //Constructer
    public NailCare() {
        this("", 0, "", 0.0);
    }

    //full Constructer
    public NailCare(String NailCareServiceType, int serviceNumber, String SerName, double price) {
        super(serviceNumber, SerName, price);
        this.NailCareServiceType = NailCareServiceType;
    }

    //All Getter
    public String getNailCareServiceType() {
        return NailCareServiceType;
    }

    public static double getMAX_DISCOUNT() {
        return MAX_DISCOUNT;
    }

    //All Setter
    public void setNailCareServiceType(String NailCareServiceType) {
        this.NailCareServiceType = NailCareServiceType;
    }

    //behavior
    @Override
    public double discount() {
        return 0.15;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("\n**NailCare**\n%s\n%s\n", super.toString(),  getNailCareServiceType());
    }

}
