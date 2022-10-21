import java.nio.charset.StandardCharsets;
import java.util.*;

public class ShoppingCart {
    final String MARKER = "********************";

    public static int counter;
    protected int myOrderNumber;
    protected Map<Product, Integer> myOrder = new HashMap();
    DeliveryImpl deliveryImpl = new DeliveryImpl();

    public ShoppingCart() {
        counter++;
    }

    public boolean isEmpty() {
        return myOrder.isEmpty();
    }

    public void addProduct(Product product, int quantity) {
        myOrder.put(product, quantity);
        this.myOrderNumber = counter;
    }

    public void deleteProduct(Product product) {
        myOrder.remove(product);
        if (myOrder.isEmpty()) {
            System.out.println("Корзина пуста");
            counter--;
        }
    }

    public void showFullOrder() {
        System.out.println(MARKER);
        for (Map.Entry<Product, Integer> item : myOrder.entrySet()) {
            System.out.printf("%s  - %s \n", item.getKey().getName(), item.getValue() + " шт.");
        }
        System.out.println(MARKER);
    }

    public void buy(Purchaser purchaser) {
        System.out.println("Вы заказали: ");
        showFullOrder();
        System.out.println("Номер Вашего заказа: " + myOrderNumber);
        deliveryImpl.deliver(purchaser.getAddress());
    }

    public void delete() {
        myOrder.clear();
        System.out.println("Ваш заказ №" + counter + " отменен");
        counter--;
    }

}
