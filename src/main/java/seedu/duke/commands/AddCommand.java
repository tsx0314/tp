package seedu.duke.commands;

import seedu.duke.food.Food;
import seedu.duke.food.FoodList;

import java.util.Arrays;


/**
 * Represent an add command
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final String ADD_MESSAGE = "I have added this product! :)";

    private static final String NAME_SEPARATOR = " -n ";
    private static final String EXPIRY_SEPARATOR = " -e ";
    private static final String QUANTITY_SEPARATOR = " -q ";
    private static final String UNIT_SEPARATOR = "-u";
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
        assert !name.trim().isEmpty() : "Expected non-empty string for name";
        assert !date.trim().isEmpty() : "Expected non-empty string for date";

        Food newFood;

        assert foodDetails.length == 2 || foodDetails.length == 3 || foodDetails.length == 4: "Wrong food details size";
        if (foodDetails.length == 2) {
            newFood = new Food(name, date);
        }
        else if (foodDetails.length == 3) {
            String q = foodDetails[2];
            double quantity = Double.valueOf(q);
            newFood = new Food(name, date, quantity);
        }
        else {
            String q = foodDetails[2];
            String u = foodDetails[3];
            double quantity = Double.valueOf(q);
            newFood = new Food(name, date, quantity, u);
        }
        System.out.println(newFood);

        foodList.addFood(newFood);
        System.out.println();
        return new CommandResult(ADD_MESSAGE);
    }

    public String getUnitOfFood(String unit_temp, double quantityInDouble){
        String unitOfMeasurement;
        if (unit_temp.equals("mg") || unit_temp.equals("milligram") || unit_temp.equals("milligrams") ||
            unit_temp.equals("milli gram") || unit_temp.equals("milli grams")){
            unitOfMeasurement = String.valueOf(Unit.mg);
        }
        else if(unit_temp.equals("gram") || unit_temp.equals("g") || unit_temp.equals("grams")){
            unitOfMeasurement = String.valueOf(Unit.g);
        }
        else if (unit_temp.equals("kg") || unit_temp.equals("kilogram") || unit_temp.equals("kilograms") ||
                unit_temp.equals("kilo gram") || unit_temp.equals("kilo grams")){
            unitOfMeasurement = String.valueOf(Unit.kg);
        }
        else if (unit_temp.equals("ml") || unit_temp.equals("millilitre") || unit_temp.equals("millilitres") ||
                unit_temp.equals("milli litre") || unit_temp.equals("milli litres")){
            unitOfMeasurement = String.valueOf(Unit.ml);
        }
        else if (unit_temp.equals("l") || unit_temp.equals("litre") || unit_temp.equals("litres")){
            unitOfMeasurement = String.valueOf(Unit.l);
        }
        else if ( (unit_temp.equals("serving") || unit_temp.equals("servings")) && quantityInDouble == 1 ){
            unitOfMeasurement = String.valueOf(Unit.serving);
        }
        else if ( (unit_temp.equals("servings") || unit_temp.equals("serving")) && quantityInDouble > 1){
            unitOfMeasurement = String.valueOf(Unit.servings);
        }
        else if ( (unit_temp.equals("unit") || unit_temp.equals("units")) && quantityInDouble == 1){
            unitOfMeasurement = String.valueOf(Unit.unit);
        }
        else if ( (unit_temp.equals("units") || unit_temp.equals("unit")) && quantityInDouble > 1 ){
            unitOfMeasurement = String.valueOf(Unit.units);
        }
        else if ( (unit_temp.equals("box") || unit_temp.equals("boxes")) && quantityInDouble == 1){
            unitOfMeasurement = String.valueOf(Unit.box);
        }
        else if ( (unit_temp.equals("boxes") || unit_temp.equals("box")) && quantityInDouble > 1){
            unitOfMeasurement = String.valueOf(Unit.boxes);
        }
        else if ( (unit_temp.equals("packet") || unit_temp.equals("packets")) && quantityInDouble == 1){
            unitOfMeasurement = String.valueOf(Unit.packet);
        }
        else if ((unit_temp.equals("packet") || unit_temp.equals("packets")) && quantityInDouble > 1){
            unitOfMeasurement = String.valueOf(Unit.packets);
        }
        else {
            unitOfMeasurement = unit_temp;
        }

        return unitOfMeasurement;
    }

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

        String[] temp = details.split(QUANTITY_SEPARATOR);
        String[] unitTemp = details.split(UNIT_SEPARATOR);

        if (temp[0].indexOf("-n") < temp[0].indexOf("-e")) {
            String[] nameAndDate = temp[0].replace(NAME_SEPARATOR, "").split(EXPIRY_SEPARATOR, 2);
            name = nameAndDate[0];
            date = nameAndDate[1];
        } else {
            String[] dateAndName = temp[0].replace(EXPIRY_SEPARATOR, "").split(NAME_SEPARATOR, 2);
            name = dateAndName[1];
            date = dateAndName[0];
        }

        if (hasQuantity && !hasUnit) {
            quantity = temp[1];
            String[] foodDetails = {name, date, quantity};
            return foodDetails;
        }

        if(hasUnit){
            String[] quantityTemp = unitTemp[0].replace(UNIT_SEPARATOR, "").split(QUANTITY_SEPARATOR);
            quantity = quantityTemp[1].trim();
            String unit_temp = unitTemp[1].trim();
            double quantityInDouble = Double.parseDouble(quantity);
            unit = getUnitOfFood(unit_temp, quantityInDouble);

            String[] foodDetails = {name, date, quantity, unit};
            return foodDetails;
        }

        String[] foodDetails = {name, date};
        return foodDetails;
    }
}
