import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //dependency inversion principle + Liskov Substitution principle
        Product potato = new NonDurableProduct("1", "Картофель", 5, 4.3,
                "Белоруссия", new GregorianCalendar(2023, Calendar.JANUARY, 20));
        Product milk = new NonDurableProduct("4", "Молоко", 25, 4.8, "Россия",
                new GregorianCalendar(2022, Calendar.NOVEMBER, 5));
        Product cheese = new NonDurableProduct("5", "Сыр", 100, 5, "Франция",
                new GregorianCalendar(2023, Calendar.FEBRUARY, 1));
        Product vine = new NonDurableProduct("8", "Вино", 150, 5, "Италия",
                new GregorianCalendar(2025, Calendar.MARCH, 31));
        Product headPhones = new DurableProduct("10", "Наушники", 600.5, 5,
                "Китай", 12);

        ProductsForSale productsForSale = new ProductsForSale()
                .addProduct(potato)
                .addProduct(milk)
                .addProduct(cheese)
                .addProduct(vine)
                .addProduct(headPhones);

        Purchaser purchaser;
        System.out.println("Добрый день! Для заказа, пожалуйста, введите имя и адрес.");
        System.out.print("Имя: ");
        Scanner scanner = new Scanner(System.in);
        String purchaserName = scanner.nextLine();

        System.out.print("Введите адрес: ");
        Address address = new Address(scanner.nextLine());

        System.out.print("Введите способ оплаты (наличные или по карте): ");
        String purchaserPaymentPreference = scanner.nextLine();


        if (purchaserPaymentPreference.equals("по карте")) {
            System.out.print("Введите номер карты для оплаты: ");
            String purchaserPaymentDetails = scanner.nextLine();
            purchaser = new Purchaser(purchaserName, address, purchaserPaymentDetails);
        } else {
            purchaser = new Purchaser(purchaserName, address);
        }

        System.out.println("Выберите товары для заказа и укажите количество (или end для завершения заказа)");
        productsForSale.showProductsForSale();

        while (true) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Укажите товар: ");
            String productName = scanner1.nextLine();

            if (productName.equals("end")) {
                break;
            }
            System.out.println("Укажите количество: ");
            int quantity = scanner1.nextInt();
            Product product = productsForSale.getProductByName(productName);
            purchaser.shoppingCart.addProduct(product, quantity);
        }

        System.out.println("Укажите buy для оформления заказа, либо delete, если хотите удалить товар из корзины");
        String input = scanner.nextLine();
        if (input.equals("buy")) {
            purchaser.shoppingCart.buy(purchaser);
        } else if (input.equals("delete")) {
            System.out.println("Укажите, какие товары удалить из заказа (или end для завершения заказа)");
            while (true) {
                if (purchaser.shoppingCart.isEmpty()) {
                    break;
                }
                System.out.println("Укажите товар для удаления: ");
                String productName = scanner.nextLine();
                if (productName.equals("end")) {
                    break;
                }
                Product product = productsForSale.getProductByName(productName);
                purchaser.shoppingCart.deleteProduct(product);
            }

            if (purchaser.shoppingCart.isEmpty()) {
                System.out.println("Ваша корзина пуста, чтобы сделать заказ, выберите что-нибудь");
            } else {
                System.out.println("Укажите buy для оформления заказа, либо delete для отмены заказа");
                input = scanner.nextLine();
                if (input.equals("buy")) {
                    purchaser.shoppingCart.buy(purchaser);

                } else if (input.equals("delete")) {
                    purchaser.shoppingCart.delete();
                }
            }
        }
    }
}
