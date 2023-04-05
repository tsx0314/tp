package seedu.duke.commands;

import seedu.duke.food.Food;
import seedu.duke.food.FoodCategory;
import seedu.duke.food.FoodList;
import seedu.duke.food.Unit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


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
            "Please input a valid date :<";
    private static final String EXPIRY_DATE_MESSAGE =
            "Please do not add an expired product :<";
    private static final String INVALID_INPUT_MESSAGE = "Please use reasonable value :<";

    private static final String MILLIGRAM_1 = "mg";
    private static final String MILLIGRAM_2 = "milligram";
    private static final String MILLIGRAM_3 = "milligrams";
    private static final String MILLIGRAM_4 = "milli gram";
    private static final String MILLIGRAM_5 = "milli grams";
    private static final String GRAM_1 = "gram";
    private static final String GRAM_2 = "g";
    private static final String GRAM_3 = "grams";
    private static final String KILOGRAM_1 = "kg";
    private static final String KILOGRAM_2 = "kilogram";
    private static final String KILOGRAM_3 = "kilograms";
    private static final String KILOGRAM_4 = "kilo gram";
    private static final String KILOGRAM_5 = "kilo grams";
    private static final String MILLIMETRE_1 = "ml";
    private static final String MILLIMETRE_2 = "millilitre";
    private static final String MILLIMETRE_3 = "millilitres";
    private static final String MILLIMETRE_4 = "milli litre";
    private static final String MILLIMETRE_5 = "milli litres";
    private static final String LITRE_1 = "l";
    private static final String LITRE_2 = "litre";
    private static final String LITRE_3 = "litres";
    private static final String SERVING_1 = "serving";
    private static final String SERVING_2 = "servings";
    private static final String UNIT_1 = "unit";
    private static final String UNIT_2 = "units";
    private static final String BOX_1 = "box";
    private static final String BOX_2 = "boxes";
    private static final String PACKET_1 = "packet";
    private static final String PACKET_2 = "packets";

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
        boolean hasQuantity = details.contains("-q");
        boolean hasCategory = details.contains("-c");
        boolean hasUnit = details.contains(UNIT_SEPARATOR);
        String[] foodDetails = splitDetails(details);
        assert foodDetails.length >= 2 : "Input is wrong";
        String name = foodDetails[0];
        String date = foodDetails[1];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate expiryDate = LocalDate.parse(date, formatter);
            boolean isValid = isValid(date);
            boolean isNew = isTheDateAfterCurrentDate(expiryDate);
            if (!isValid) {
                return new CommandResult(INVALID_DATE_MESSAGE);
            }
            if (!isNew) {
                return new CommandResult(EXPIRY_DATE_MESSAGE);
            }
            assert !name.trim().isEmpty() : "Expected non-empty string for name";
            assert !date.trim().isEmpty() : "Expected non-empty string for date";

            Food newFood;

            assert foodDetails.length == 2 || foodDetails.length == 3 ||
                    foodDetails.length == 4 || foodDetails.length == 5 : "Wrong food details size";


            if (foodDetails.length == 2) {
                newFood = new Food(name, date);
            } else if (foodDetails.length == 3 && hasCategory && !hasQuantity) {
                String c = foodDetails[2];
                FoodCategory category = compareCategory(c);
                newFood = new Food(name, date, category);
            } else if (foodDetails.length == 3 && !hasCategory && hasQuantity) {
                String q = foodDetails[2];
                if (!isNumberValid(q)) {
                    return new CommandResult(INVALID_INPUT_MESSAGE);
                }
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < 9999;
                Double quantity = Double.valueOf(q);
                newFood = new Food(name, date, quantity);
            } else if (foodDetails.length == 4 && hasUnit) {
                String q = foodDetails[2];
                if (!isNumberValid(q)) {
                    return new CommandResult(INVALID_INPUT_MESSAGE);
                }
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < 9999;
                Double quantity = Double.valueOf(q);
                String unit = getUnitOfFood(foodDetails[3], quantity);
                newFood = new Food(name, date, quantity, unit);
            } else if (foodDetails.length == 4 && !hasUnit) {
                String q = foodDetails[2];
                if (!isNumberValid(q)) {
                    return new CommandResult(INVALID_INPUT_MESSAGE);
                }
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < 9999;
                Double quantity = Double.valueOf(q);
                FoodCategory category = compareCategory(foodDetails[3]);
                newFood = new Food(name, date, quantity, category);
            } else {
                String q = foodDetails[2];
                if (!isNumberValid(q)) {
                    return new CommandResult(INVALID_INPUT_MESSAGE);
                }
                assert Double.valueOf(q) > 0 && Double.valueOf(q) < 9999;
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
        if (unitTemporary.equals(MILLIGRAM_1) || unitTemporary.equals(MILLIGRAM_2) ||
                unitTemporary.equals(MILLIGRAM_3) || unitTemporary.equals(MILLIGRAM_4) ||
                unitTemporary.equals(MILLIGRAM_5)) {
            unitOfMeasurement = String.valueOf(Unit.MILLIGRAM.abbreviation);
        } else if (unitTemporary.equals(GRAM_1) || unitTemporary.equals(GRAM_2) ||
                unitTemporary.equals(GRAM_3)) {
            unitOfMeasurement = String.valueOf(Unit.GRAM.abbreviation);
        } else if (unitTemporary.equals(KILOGRAM_1) || unitTemporary.equals(KILOGRAM_2) ||
                unitTemporary.equals(KILOGRAM_3) || unitTemporary.equals(KILOGRAM_4) ||
                unitTemporary.equals(KILOGRAM_5)) {
            unitOfMeasurement = String.valueOf(Unit.KILOGRAM.abbreviation);
        } else if (unitTemporary.equals(MILLIMETRE_1) || unitTemporary.equals(MILLIMETRE_2) ||
                unitTemporary.equals(MILLIMETRE_3) || unitTemporary.equals(MILLIMETRE_4) ||
                unitTemporary.equals(MILLIMETRE_5)) {
            unitOfMeasurement = String.valueOf(Unit.MILLILITER.abbreviation);
        } else if (unitTemporary.equals(LITRE_1) || unitTemporary.equals(LITRE_2) ||
                unitTemporary.equals(LITRE_3)){
            unitOfMeasurement = String.valueOf(Unit.LITER.abbreviation);
        } else if ((unitTemporary.equals(SERVING_1) || unitTemporary.equals(SERVING_2))
                && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.SERVING.abbreviation);
        } else if ((unitTemporary.equals(SERVING_2) || unitTemporary.equals(SERVING_1))
                && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.SERVINGS.abbreviation);
        } else if ((unitTemporary.equals(UNIT_1) || unitTemporary.equals(UNIT_2))
                && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.UNIT.abbreviation);
        } else if ((unitTemporary.equals(UNIT_2) || unitTemporary.equals(UNIT_1))
                && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.UNITS.abbreviation);
        } else if ((unitTemporary.equals(BOX_1) || unitTemporary.equals(BOX_2))
                && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.BOX.abbreviation);
        } else if ((unitTemporary.equals(BOX_2) || unitTemporary.equals(BOX_1))
                && quantityInDouble > 1) {
            unitOfMeasurement = String.valueOf(Unit.BOXES.abbreviation);
        } else if ((unitTemporary.equals(PACKET_1) || unitTemporary.equals(PACKET_2))
                && quantityInDouble == 1) {
            unitOfMeasurement = String.valueOf(Unit.PACKET.abbreviation);
        } else if ((unitTemporary.equals(PACKET_1) || unitTemporary.equals(PACKET_2))
                && quantityInDouble > 1) {
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
    public boolean isTheDateAfterCurrentDate(LocalDate expiryDate) {
        LocalDate currentDate = LocalDate.now();
        boolean isValid = expiryDate.isAfter(currentDate);
        return isValid;
    }

    public boolean isValid(String date) {
        String[] splitString = date.split("/", 3);
        String d = splitString[0];
        String m = splitString[1];
        String y = splitString[2];

        if (Integer.parseInt(y) % 4 != 0 && m.equals("02")) {
            if (d.equals("29")) {
                return false;
            }
        }
        return true;
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
        case "vegetable":
            return FoodCategory.VEGETABLE;
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

    boolean isNumberValid(String number) {
        if (number.length() >= 5) {
            return false;
        }
        return true;
    }
}

