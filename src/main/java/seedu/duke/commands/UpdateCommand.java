package seedu.duke.commands;


import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.IllegalValueException;
import seedu.duke.exceptions.InvalidFlagException;
import seedu.duke.food.Food;
import seedu.duke.food.FoodList;
import seedu.duke.utils.Validator;

import java.util.Arrays;

//@@author DavidVin357

/**
 * Represents "update" command - updates a product attributes with given flag values
 */
public class UpdateCommand extends Command {
    public static final String COMMAND_WORD = "update";
    private static final String FLAG_SEPARATOR = "--";
    String index;
    String[] flags;

    /**
     * Initializes UpdateCommand object
     * with index and flags obtained from the arguments provided
     *
     * @param arguments
     * @throws DukeException
     */
    public UpdateCommand(String arguments) throws DukeException {
        if (!arguments.contains(FLAG_SEPARATOR)) {
            throw new DukeException("No field to update is specified");
        }
        String[] details = arguments.split(FLAG_SEPARATOR);
        this.index = details[0];
        this.flags = Arrays.copyOfRange(details, 1, details.length);
    }

    /**
     * A core logic method for updating the current food attributes with given flag values
     *
     * @param currentFood
     * @param flagName
     * @param flagValue
     * @throws DukeException
     */
    private void updateFoodAttribute(Food currentFood, String flagName, String flagValue) throws DukeException {
        try {
            switch (flagName) {
            case "n":
                currentFood.setName(flagValue);
                break;
            case "e":
                Validator.isExpiryDateValid(flagValue);
                currentFood.setExpiryDate(flagValue);
                break;
            case "q":
                if (currentFood.getQuantity() == 0 && Arrays.asList(flags).contains("u")) {
                    throw new DukeException("Can't set quantity with no unit provided");
                }
                currentFood.setQuantity(Double.parseDouble(flagValue));
                String currentFoodUnit = currentFood.getUnit();
                currentFood.setUnit(currentFoodUnit);
                break;
            case "u":
                currentFood.setUnit(flagValue);
                break;
            case "c":
                currentFood.setCategory(flagValue);
                break;
            default:
                throw new InvalidFlagException(flagName);
            }
        } catch (DukeException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalValueException("Illegal value for the flag " + flagName);
        }
    }

    /**
     * @param foodList
     * @return CommandResult
     * @throws DukeException
     */
    @Override
    public CommandResult execute(FoodList foodList) throws DukeException {

        int index = 1;
        try {
            index = Integer.parseInt(this.index.trim()) - 1;
        } catch (NumberFormatException e) {
            int numberOfFood = foodList.getNumberOfFood();
            String wrongIndexMessage = "Invalid index format! Please give an index within range of " + numberOfFood;
            throw new DukeException(wrongIndexMessage);
        }
        Food currentFood = foodList.getFood(index);

        for (String flag : flags) {
            String[] flagParts = flag.trim().split(" ", 2);

            if (flagParts.length == 1) {
                String invalidFlagName = flagParts[0];
                throw new InvalidFlagException(invalidFlagName);
            }
            String flagName = flagParts[0].trim().toLowerCase();
            String flagValue = flagParts[1].trim().toLowerCase();

            updateFoodAttribute(currentFood, flagName, flagValue);
        }
        return new CommandResult("Updated food item successfully! \n" + foodList.getFood(index));
    }
}
