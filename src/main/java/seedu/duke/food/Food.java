package seedu.duke.food;
import java.time.LocalDate;


public class Food {
    private String name;
    private String expiryDate;
    private Double quantity;

    public Food(String name, String expiryDate, Double quantity) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public Food(String name, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = 0.0;
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public LocalDate formatDate(String expiryDate) {
        return LocalDate.parse(expiryDate);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        Double quantity = getQuantity();
        String foodDetail = null;
        if (quantity == 0.0) {
            foodDetail = getName() + "\n       Expiry date: " + getExpiryDate();
        } else {
            foodDetail = getName() + "\n       Expiry date: " + getExpiryDate() + "\n       Remaining quantity: " + getQuantity();
        }
        return foodDetail;
    }
}
