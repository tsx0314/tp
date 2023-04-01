package seedu.duke.commands;

import seedu.duke.food.Food;
import seedu.duke.food.FoodCategory;
import seedu.duke.food.FoodList;
import seedu.duke.food.Unit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.lang.Short.MAX_VALUE;


/**
 * Represent an add command
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final String ADD_MESSAGE = "I have added this product! :)";

    private static final String NAME_SEPARATOR = "-n";
    private static final String EXPIRY_SEPARATOR = "-e";

    private static final String CATEGORY_SEPARATOR = "-c";
    private static final String QUANTITY_SEPARATOR = "-q";
    private static final String UNIT_SEPARATOR = "-u";

    private static final String INVALID_DATE_MESSAGE =
            "Please input a valid  date :<";
    private static final String EXPIRY_DATE_MESSAGE =
            "Please do not add an expired product :<";

    public String details;

    /**
     * Constructor
     *
     * @param details food details
     */
    public AddCommand(String details) {
        this.details = details;
    }

    /**
     * Returns a CommandResult object to display the successful message after executing the command as below
     * Separate the food name and the expiry date details and add a new food item in the list
     *
     * @param foodList a food list
     * @return a CommandResult object to display the successful message
     */
    public CommandResult execute(FoodList foodList) {
        boolean hasUnit = details.contains("-u");
        String[] foodDetails = splitDetails(details);
        assert foodDetails.length >= 2 : "Input is wrong";
        String name = foodDetails[0];
        String date = foodDetails[1];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate expiryDate = LocalDate.parse(date, formatter);
            boolean isValid = isValidDate(expiryDate);
            if (!isValid) {
                return new CommandResult(EXPIRY_DATE_MESSAGE);
            }
            assert !name.trim().isEmpty() : "Expected non-empty string for name";
            assert !date.trim().isEmpty() : "Expected non-empty string for date";

            Food newFood;

            assert foodDetails.length == 2 || foodDetails.length == 3 ||
                    foodDetails.length == 4 || foodDetails.length == 5 : "Wrong food details size";

            if (foodDetails.length == 2) {
                newFood = new Food(name, date);
            } else if (foodDetails.length == 3) {
                String c = foodDetails[2];
                FoodCategory category = compareCategory(c);
                newFood = new Food(name, date, category);
            } else if (foodDetails.length == 4 && hasUnit) {
                String q = foodDetails[2];
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < MAX_VALUE;
                Double quantity = Double.valueOf(q);
                String unit = getUnitOfFood(foodDetails[3], quantity);
                newFood = new Food(name, date, quantity, unit);
            } else if (foodDetails.length == 4 && !hasUnit) {
                String q = foodDetails[2];
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < MAX_VALUE;
                Double quantity = Double.valueOf(q);
                FoodCategory category = compareCategory(foodDetails[3]);
                newFood = new Food(name, date, quantity, category);
            } else {
                String q = foodDetails[2];
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < MAX_VALUE;
                Double quantity = Double.valueOf(q);
                String unit = getUnitOfFood(foodDetails[3], quantity);
                String c = foodDetails[4];
                FoodCategory category = compareCategory(c);
                newFood = new Food(name, date, quantity, unit, category);
            }
            System.out.println(newFood);
            foodList.addFood(newFood);
            System.out.println();
            return new CommandResult(ADD_MESSAGE);
        } catch (DateTimeParseException e) {
            return new CommandResult(INVALID_DATE_MESSAGE);
        }
    }

    //@@author wanjuin

    /**
     * Returns the unit of the food
     *
     * @param unitTemporary    a unit
     * @param quantityInDouble quantity
     * @return unitOfMeasurement a food unit
     */
    public String getUnitOfFood(String unitTemporary, Double quantityInDouble) {
        String unitOfMeasurement;
        if (unitTemporary.equals("mg") || unitTemporary.equals("milligram") || unitTemporary.equals("milligrams") ||
                unitTemporary.equals("milli gram") || unitTemporary.equals("milli grams")) {
            unitOfMeasurement = String.valueOf(Unit.MILLIGRAM.abbreviation);
        } else if (unitTemporary.equals("gram") || unitTemporary.equals("g") || unitTemporary.equals("grams")) {
            unitOfMeasurement = String.valueOf(Unit.GRAM.abbreviation);
        } else if (unitTemporary.equals("kg") || unitTemporary.equals("kilogram")
                || unitTemporary.equals("kilograms") || unitTemporary.equals("kilo gram") ||
                unitTemporary.equals("kilo grams")) {
            unitOfMeasurement = String.valueOf(Unit.KILOGRAM.abbreviation);
        } else if (unitTemporary.equals("ml") || unitTemporary.equals("millilitre") ||
                unitTemporary.equals("millilitres") || unitTemporary.equals("milli litre")
                || unitTemporary.equals("milli litres")) {
            unitOfMeasurement = String.valueOf(Unit.MILLILITER.abbreviation);
        } else if (unitTemporary.equals("l") || unitTemporary.equals("litre") || unitTemporary.equals("litres")) {
            unitOfMeasurement = String.valueOf(Unit.LITER.abbreviation);
        } else if ((unitTemporary.equals("serving") || unitTemporary.equals("servings")) && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.SERVING.abbreviation);
        } else if ((unitTemporary.equals("servings") || unitTemporary.equals("serving")) && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.SERVINGS.abbreviation);
        } else if ((unitTemporary.equals("unit") || unitTemporary.equals("units")) && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.UNIT.abbreviation);
        } else if ((unitTemporary.equals("units") || unitTemporary.equals("unit")) && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.UNITS.abbreviation);
        } else if ((unitTemporary.equals("box") || unitTemporary.equals("boxes")) && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.BOX.abbreviation);
        } else if ((unitTemporary.equals("boxes") || unitTemporary.equals("box")) && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.BOXES.abbreviation);
        } else if ((unitTemporary.equals("packet") || unitTemporary.equals("packets")) && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.PACKET.abbreviation);
        } else if ((unitTemporary.equals("packet") || unitTemporary.equals("packets")) && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.PACKETS.abbreviation);
        } else {
            unitOfMeasurement = unitTemporary;
        }
        return unitOfMeasurement;
    }

    //@@author tsx0314

    /**
     * Returns an array of String to store the information of food added
     *
     * @param details food details
     * @return foodDetails a String array of the food details
     */
    public String[] splitDetails(String details) {
        boolean hasQuantity = details.contains("-q");
        boolean hasUnit = details.contains("-u");
        boolean hasCat = details.contains("-c");


        String name;
        String date;
        String category;
        String quantity;
        String unit;

        String[] temp = details.trim().split(QUANTITY_SEPARATOR);
        String[] temp2 = temp[0].split(CATEGORY_SEPARATOR);
        String[] nameAndExpiryDate = temp2[0].replace(NAME_SEPARATOR, "").trim().split(EXPIRY_SEPARATOR, 2);

        name = nameAndExpiryDate[0].trim();
        date = nameAndExpiryDate[1].trim();

        if (!hasCat && !hasUnit && !hasQuantity) {
            String[] foodDetails = {name, date};
            return foodDetails;
        }

        if (hasCat && !hasUnit && !hasQuantity) {
            category = temp2[1].trim();
            String[] foodDetails = {name, date, category};
            return foodDetails;
        }

        if (!hasCat && hasQuantity && !hasUnit) {
            quantity = temp[1].trim();
            String[] foodDetails = {name, date, quantity};
            return foodDetails;
        }

        if (hasCat && hasQuantity && !hasUnit) {
            quantity = temp[1].trim();
            category = temp2[1].trim();
            String[] foodDetails = {name, date, quantity, category};
            return foodDetails;
        }
        if (!hasCat && hasUnit && hasQuantity) {
            String[] quantityAndUnit = temp[1].trim().split(UNIT_SEPARATOR, 2);
            unit = quantityAndUnit[1].trim();
            quantity = quantityAndUnit[0].trim();
            String[] foodDetails = {name, date, quantity, unit};
            return foodDetails;
        }

        category = temp2[1].trim();
        quantity = temp[1].trim().split(UNIT_SEPARATOR, 2)[0].trim();
        unit = temp[1].trim().split(UNIT_SEPARATOR, 2)[1].trim();
        String[] foodDetails = {name, date, quantity, unit, category};
        return foodDetails;
    }

    //@@author tsx0314

    /**
     * Returns whether the input date is a valid expiry date
     *
     * @param expiryDate the date
     * @return isValid whether the date is valid
     */
    public boolean isValidDate(LocalDate expiryDate) {
        LocalDate currentDate = LocalDate.now();
        boolean isValid = expiryDate.isAfter(currentDate);
        return isValid;
    }

    /**
     * Return a food category according to the input
     *
     * @param tempCategory
     * @return an enum FoodCategory
     */
    public FoodCategory compareCategory(String tempCategory) {

        String cat = tempCategory.toLowerCase();

        switch (cat) {
        case "fruit":
            return FoodCategory.FRUIT;
        case "meat":
            return FoodCategory.MEAT;
        case "dairy":
            return FoodCategory.DAIRY;
        case "grain":
            return FoodCategory.GRAIN;
        case "seafood":
            return FoodCategory.SEAFOOD;
        case "beverage":
            return FoodCategory.BEVERAGE;
        default:
            return FoodCategory.OTHERS;
        }
    }
}

