package seedu.duke.food;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Food {
    private String name;
    private String expiryDate;
    private Double quantity;
    private String unit;

    private FoodCategory category;

    /**
     * Constructor
     *
     * @param name       food name
     * @param expiryDate food expiry date
     * @param quantity   food quantity
     * @param unit       food unit
     * @param category   food category
     */
    public Food(String name, String expiryDate, Double quantity, String unit, FoodCategory category) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
    }

    public Food(String name, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.category = FoodCategory.OTHERS;
        this.quantity = 0.0;
    }

    /**
     * Constructor for Food object with no quantity and no unit
     *
     * @param name       food name
     * @param expiryDate food expiry date
     * @param category   food category
     */
    public Food(String name, String expiryDate, FoodCategory category) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = 0.0;
        this.category = category;
    }

    public Food(String name, String expiryDate, Double quantity) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.category = FoodCategory.OTHERS;
    }

    public Food(String name, String expiryDate, Double quantity, FoodCategory category) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.category = category;
    }

    public Food(String name, String expiryDate, Double quantity, String unit) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.unit = unit;
        this.category = FoodCategory.OTHERS;
    }


    public Food(String name, String expiryDate, Double quantity, String unit, String category) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.category = FoodCategory.valueOf(category);
        this.quantity = quantity;
        this.unit = unit;
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public LocalDate parseExpiryDate() {
        return LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public FoodCategory getCategory() {
        return category;
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

    public void setCategory(String category) {
        for (FoodCategory c : FoodCategory.values()) {
            if (getCategoryString(c).equals(category.toLowerCase().trim())) {
                this.category = c;
                return;
            }
        }
        // If no category matched, set as unclassified
        this.category = FoodCategory.OTHERS;
    }

    public String getCategoryString(FoodCategory category) {
        switch (category) {
        case FRUIT:
            return "fruit";
        case MEAT:
            return "meat";
        case DAIRY:
            return "dairy";
        case GRAIN:
            return "grain";
        case BEVERAGE:
            return "beverage";
        case SEAFOOD:
            return "seafood";
        case VEGETABLE:
            return "vegetable";
        case OTHERS:
            return "others";
        default:
            return "others";

        }
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Returns a food product name
     *
     * @return name food name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a food expiry date string
     *
     * @return expiryDate food expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    public boolean isFresh(){
        LocalDate expiryDate = parseExpiryDate();
        boolean isFreshFood = expiryDate.isAfter(LocalDate.now());
        return isFreshFood;
    }
    public String getExpiryStatus() {
        String expiryStatus = null;
        if(!isFresh()){
            expiryStatus = " (expired) ";
        }
        else {
            expiryStatus = " (fresh) ";
        }
        return expiryStatus;
    }

    public long getDaysExpire (){
        LocalDate expiryDate = parseExpiryDate();
        long days = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        return days;
    }

    public String getDaysString(){
        if(isFresh()) {
            String daysToExpireNotice = null;
            daysToExpireNotice = " (" + getDaysExpire() + " days left)";
            return daysToExpireNotice;
        }

        String daysExpiredNotice = null;
        long convertToPositiveDays = (-1) * getDaysExpire();
        daysExpiredNotice = " (expired " + convertToPositiveDays + " days)";
        return daysExpiredNotice;
    }
    //@@author david

    /**
     * Returns a foodDetail string
     *
     * @return foodDetails a String of complete food details to be printed
     */
    @Override
    public String toString() {
        Double quantity = getQuantity();
        String foodDetail = null;

        if (quantity == 0.0) {
            foodDetail = getName() + getExpiryStatus()
                    + "\n       Expiry date: " + getExpiryDate() + getDaysString()
                    + "\n       Category: " + getCategoryString(getCategory());
        } else if (getUnit() == null) {
            foodDetail = getName() + getExpiryStatus()
                    + "\n       Expiry date: " + getExpiryDate() + getDaysString()
                    + "\n       Category: " + getCategoryString(getCategory())
                    + "\n       Remaining quantity: " + getQuantity();
        } else {
            foodDetail = getName() + getExpiryStatus()
                    + "\n       Expiry date: " + getExpiryDate() + getDaysString()
                    + "\n       Category: " + getCategoryString(getCategory())
                    + "\n       Remaining quantity: " + getQuantity() + " " + getUnit();
        }
        return foodDetail;
    }
}
