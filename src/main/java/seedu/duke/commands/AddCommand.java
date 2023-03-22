package seedu.duke.commands;

import seedu.duke.food.Food;
import seedu.duke.food.FoodList;

/**
 * Represent a add command
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final String ADD_MESSAGE = "I have added this product! :)";

    private static final String NAME_SEPARATOR = " -n ";
    private static final String EXPIRY_SEPARATOR = " -e ";

    private static final String QUANTITY_SEPARATOR = " -q ";
    public String details;

    /**
     * Constructor
     *
     * @param details
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
        assert name instanceof String && !name.trim().isEmpty() : "Expected non-empty string for name";
        assert date instanceof String && !date.trim().isEmpty() : "Expected non-empty string for date";

        Food newFood;

        if (foodDetails.length <= 2) {
            newFood = new Food(name, date);
        } else {
            String q = foodDetails[2];
            double quantity = Double.valueOf(q);
            newFood = new Food(name, date, quantity);
        }
        System.out.println(newFood);
        foodList.addFood(newFood);
        System.out.println();
        return new CommandResult(ADD_MESSAGE);
    }

    /**
     * Returns an array of String to store the information of food name, expiry date (and quantity)
     *
     * @param details
     * @return nameAndDate a String array of the food name, the expiry date (and quantity)
     */
    public String[] splitDetails(String details) {
        boolean hasQuantity = details.contains("-q");

        String name;
        String date;

        if (hasQuantity) {
            String[] temp = details.split(QUANTITY_SEPARATOR);
            String quantity = temp[1];

            if (temp[0].indexOf("-n") < temp[0].indexOf("-e")) {
                String[] nameAndDate = temp[0].replace(NAME_SEPARATOR, "").split(EXPIRY_SEPARATOR, 2);
                name = nameAndDate[0];
                date = nameAndDate[1];
            } else {
                String[] dateAndName = temp[0].replace(EXPIRY_SEPARATOR, "").split(NAME_SEPARATOR, 2);
                name = dateAndName[1];
                date = dateAndName[0];
            }

            String[] foodDetails = {name, date, quantity};
            return foodDetails;
        }
        
        if (details.indexOf("-n") < details.indexOf("-e")) {
            String[] nameAndDate = details.replace(NAME_SEPARATOR, "").split(EXPIRY_SEPARATOR, 2);
            name = nameAndDate[0];
            date = nameAndDate[1];
        } else {
            String[] dateAndName = details.replace(EXPIRY_SEPARATOR, "").split(NAME_SEPARATOR, 2);
            name = dateAndName[1];
            date = dateAndName[0];
        }
        String[] foodDetails = {name, date};
        return foodDetails;
    }

}
