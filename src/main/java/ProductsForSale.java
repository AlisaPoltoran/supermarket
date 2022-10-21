import java.util.ArrayList;
import java.util.List;

public class ProductsForSale {
    //dependency inversion principle
    List<Product> productList = new ArrayList<>();

    public ProductsForSale addProduct(Product product) {
        productList.add(product);
        return this;
    }

    public void showProductsForSale() {
        for(int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public int getSize() {
        return productList.size();
    }

    public Product getProductByName(String name) throws Exception {
        Product productFound = new Product();
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                productFound = product;
            }
        }
        return productFound;
    }
}
