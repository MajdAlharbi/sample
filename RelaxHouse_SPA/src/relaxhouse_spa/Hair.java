package relaxhouse_spa;

public final class Hair extends Service {

    //Properties
    private String hairServiceType;

    //defult Constructer
    public Hair() {
        this("", 0, "", 0.0);
    }

    public Hair(String hairServiceType) {
        this.hairServiceType = hairServiceType;
    }

    public Hair(String hairServiceType, int serviceNumber, String SerName, double price) {
        super(serviceNumber, SerName, price);
        this.hairServiceType = hairServiceType;
    }

    public String getHairServiceType() {
        return hairServiceType;
    }

    public static double getMAX_DISCOUNT() {
        return MAX_DISCOUNT;
    }
//all setters

    public void setHairServiceType(String hairServiceType) {
        this.hairServiceType = hairServiceType;
    }

    //behavior
    public void prinHairStyles() {
        System.out.println("11.Wavy hair");
        System.out.println("22.straight hair");
        System.out.println("33.curly hair");
    }

    @Override
    public double discount() {
        return 0.10;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("\n**Hair**\n%s\n%s\n", super.toString(), getHairServiceType());
    }

}
