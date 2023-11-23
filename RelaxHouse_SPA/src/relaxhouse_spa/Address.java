package relaxhouse_spa;

public class Address {

    //Properties
    private String Street;
    private int HousNum;

    //defult Constructer
    public Address() {
        this("", 0);
    }

    //full Constructer
    public Address(String Street, int HousNum) {
        this.Street = Street;
        this.HousNum = HousNum;
    }

    //All Getter
    public String getStreet() {
        return Street;
    }

    public int getHousNum() {
        return HousNum;
    }

    //All Setter
    public void setStreet(String Street) {
        this.Street = Street;
    }

    public void setHousNum(int HousNum) {
        this.HousNum = HousNum;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("Street :%s \nHous Number :%d\n ", Street, HousNum);
    }

}
