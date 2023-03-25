package seedu.duke.commands;

import seedu.duke.food.Food;
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
    private static final String QUANTITY_SEPARATOR = "-q";
    private static final String UNIT_SEPARATOR = "-u";

    private static final String INVALID_DATE_MESSAGE = "Please input a valid date :<";

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

        String[] foodDetails = splitDetails(details);
        assert foodDetails.length >= 2 : "Input is wrong";
        String name = foodDetails[0];
        String date = foodDetails[1];
        boolean isValid = isValidDate(date);
        if (!isValid) {
            return new CommandResult(INVALID_DATE_MESSAGE);
        }
        assert !name.trim().isEmpty() : "Expected non-empty string for name";
        assert !date.trim().isEmpty() : "Expected non-empty string for date";

        Food newFood;

        assert foodDetails.length == 2 || foodDetails.length == 3
                || foodDetails.length == 4 : "Wrong food details size";
        if (foodDetails.length == 2) {
            newFood = new Food(name, date);
        } else if (foodDetails.length == 3) {
            String q = foodDetails[2];
            assert Double.valueOf(q) < Double.MAX_VALUE : "The quantity is too large!";
            assert Double.valueOf(q) > 0 : "Please input a valid quantity!";
            Double quantity = Double.valueOf(q);
            newFood = new Food(name, date, quantity);
        } else {
            String q = foodDetails[2];
            String u = foodDetails[3];
            assert Double.valueOf(q) < Double.MAX_VALUE : "The quantity is too large!";
            assert Double.valueOf(q) > 0 : "Please input a valid quantity!";
            Double quantity = Double.valueOf(q);
            newFood = new Food(name, date, quantity, u);
        }
        System.out.println(newFood);
        foodList.addFood(newFood);
        System.out.println();
        return new CommandResult(ADD_MESSAGE);
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
     * Returns an array of String to store the information of food name, expiry date (and quantity)
     *
     * @param details food details
     * @return foodDetails a String array of the food name, the expiry date (and quantity)
     */
    public String[] splitDetails(String details) {
        boolean hasQuantity = details.contains("-q");
        boolean hasUnit = details.contains("-u");

        String name;
        String date;
        String quantity;
        String unit;

        String[] temp = details.trim().split(QUANTITY_SEPARATOR, 2);

        String[] unitTemp = details.split(UNIT_SEPARATOR);

        if (temp[0].indexOf("-n") < temp[0].indexOf("-e")) {
            String[] nameAndDate = temp[0].replace(NAME_SEPARATOR, "").trim().split(EXPIRY_SEPARATOR, 2);
            name = nameAndDate[0].trim();
            date = nameAndDate[1].trim();
        } else {
            String[] dateAndName = temp[0].replace(EXPIRY_SEPARATOR, "").trim().split(NAME_SEPARATOR, 2);
            name = dateAndName[1].trim();
            date = dateAndName[0].trim();
        }

        if (hasQuantity && !hasUnit) {
            quantity = temp[1].trim();
            String[] foodDetails = {name, date, quantity};
            return foodDetails;
        }

        if (hasUnit) {
            String[] quantityTemp = unitTemp[0].replace(UNIT_SEPARATOR, "").split(QUANTITY_SEPARATOR, 2);
            quantity = quantityTemp[1].trim();
            String unitTemporary = unitTemp[1].trim();
            Double quantityInDouble = Double.parseDouble(quantity);
            unit = getUnitOfFood(unitTemporary, quantityInDouble);
            String[] foodDetails = {name, date, quantity, unit};
            return foodDetails;
        }

        String[] foodDetails = {name, date};
        return foodDetails;
    }

    /**
     * Returns whether the input date is a valid date
     *
     * @param date the date String
     * @return isValid whether the date is valid
     */
    public boolean isValidDate(String date) {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate expiryDate = LocalDate.parse(date, formatter);
            boolean isValid = expiryDate.isAfter(currentDate);
            return isValid;
        } catch (DateTimeParseException e) {
            System.out.println("The input date is not valid");
        }
        return false;
    }
}

