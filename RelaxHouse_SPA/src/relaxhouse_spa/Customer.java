package relaxhouse_spa;

public class Customer {

    //Properties
    private String FirstName;
    private String LastName;
    private String Email;
    private int Phone;
    private int Age;
    private Address cuAddress;

    //defult Constructer
    public Customer() {
        this("", "", "", 0, 0, null);
    }

    //full Constructer
    public Customer(String FirstName, String LastName, String Email, int Phone, int Age, Address cuAddress) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Phone = Phone;
        this.Age = Age;
        this.cuAddress = cuAddress;
    }

    //All Getter
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public int getPhone() {
        return Phone;
    }

    public int getAge() {
        return Age;
    }

    public Address getCuAddress() {
        return cuAddress;
    }

    //All Setter
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setCuAddress(Address cuAddress) {
        this.cuAddress = cuAddress;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("\nYour Name :%s %s\nEmail: %s\nPhone Number : %d\nAge : %d\nAddress :\n%s\n", FirstName, LastName, Email, Phone, Age, cuAddress);
    }

}
