public class Product {
    String idNumber;
    String name;
    double price;
    double rating;
    String countryOfOrigin;

    public Product() {

    }

    public Product(String idNumber, String name, double price, double rating, String countryOfOrigin) {
        this.idNumber = idNumber;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return name +
                ", Цена за единицу - " + price + " руб." +
                ", Рейтинг: " + rating +
                ", Страна производства: " + countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    public Product getProductByName(String name) throws Exception {
        if (this.name.equals(name)) {
            return this;
        } else {
            throw new Exception("Такой товар не найден, повторите ввод");
        }
    }

}
