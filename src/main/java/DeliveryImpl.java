import java.util.Random;

public class DeliveryImpl implements Deliver {
    //single-responsibility principle & open-closed principle
    final int MAX_TIME = 121;

    @Override
    public void deliver(Address address) {
        Random random = new Random();
        int timeOfDelivery = random.nextInt(MAX_TIME);
        System.out.println("Ваш заказ будет доставлен в течение " + timeOfDelivery + " минут" +
                " по адресу " + address);
        System.out.println("Спасибо за покупку");
    }
}
