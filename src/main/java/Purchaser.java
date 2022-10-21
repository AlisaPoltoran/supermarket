public class Purchaser {
    String name;
    Address address;
    String paymentDetails;
    ShoppingCart shoppingCart = new ShoppingCart();

    public Purchaser(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Purchaser(String name, Address address, String paymentDetails) {
        this.name = name;
        this.address = address;
        this.paymentDetails = paymentDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
