import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class NonDurableProduct extends Product {
    GregorianCalendar calendar;

    public NonDurableProduct(String idNumber, String name, double price, double rating, String countryOfOrigin,
                             GregorianCalendar calendar) {
        super(idNumber, name, price, rating, countryOfOrigin);
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        return super.toString() + ", Употребить до: " + df.format(calendar.getTime());
    }
}
