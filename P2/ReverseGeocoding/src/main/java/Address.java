public class Address {
    private String road;
    private String city;
    private String state;
    private String zip;
    private String houseNumber;

    public Address(String road, String city, String state, String zip, String houseNumber){
        this.road = road;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "road='" + road + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
