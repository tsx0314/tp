package seedu.duke.food;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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

    public Food(String name, String expiryDate, Double quantity, String unit) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.unit = unit;
        this.category = FoodCategory.UNCLASSIFIED_FOOD;
    }

    public Food(String name, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.category = FoodCategory.UNCLASSIFIED_FOOD;
        this.quantity = 0.0;
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
        for (FoodCategory c : FoodCategory.values() ) {
            if (getCategoryString(c).equals(category.toLowerCase().trim())) {
                this.category = c;
                return;
            }
        }
        // If no category matched, set as unclassified
        this.category = FoodCategory.UNCLASSIFIED_FOOD;
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
            return "unknown category";

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
            foodDetail = getName() + "\n       Expiry date: " + getExpiryDate()
                    +"\n       Category: " + getCategoryString(getCategory());
        } else {
            foodDetail = getName() + "\n       Expiry date: " + getExpiryDate()
                    + "\n       Category: " + getCategoryString(getCategory())
                    + "\n       Remaining quantity: " + getQuantity() + " " + getUnit();
        }
        return foodDetail;
    }
}
