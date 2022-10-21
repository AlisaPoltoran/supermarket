public class DurableProduct extends Product{
    int warrantyPeriod;

    public DurableProduct(String idNumber, String name, double price, double rating, String countryOfOrigin, int warrantyPeriod) {
        super(idNumber, name, price, rating, countryOfOrigin);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return super.toString() + ", Гарантийный срок: " + warrantyPeriod;
    }
}
