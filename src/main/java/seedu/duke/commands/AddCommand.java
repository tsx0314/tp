package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.food.Food;
import seedu.duke.food.FoodList;
import seedu.duke.general.Ui;

import java.util.regex.Pattern;

public class AddCommand extends Command {
    private static final String ADD_COMMAND_PATTERN_1 =
            "^add\\s+-n\\s+\\w+(\\s+\\w+)*\\s+-e\\s+\\d{1,2}[/-]\\d{1,2}[/-]\\d{2,4}$";
    private static final String ADD_COMMAND_PATTERN_2 =
            "^add\\s+-e\\s+\\d{1,2}[/-]\\d{1,2}[/-]\\d{2,4}\\s+-n\\s+\\w+(\\s+\\w+)*\\s$";

    public AddCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(FoodList foodList, Ui ui) throws CommandException {
        String command = userInput.trim();

        boolean isMatched1 = Pattern.matches(ADD_COMMAND_PATTERN_1, command);
        boolean isMatched2 = Pattern.matches(ADD_COMMAND_PATTERN_2, command);

        if (!isMatched1 && !isMatched2) {
            throw new CommandException();
        }
        String[] details = splitAddCommand(command);
        String name = details[0];
        String date = details[1];

        Food newFood = new Food(name, date);
        foodList.addFood(newFood);
        ui.printAddMessage();
        newFood.printFoodDetails();

    }

    public static String[] splitAddCommand(String command) {
        String commandDetails = command.replace("add", "");
        String[] splitCommand = commandDetails.split(" -n ");
        String[] nameAndDate;
        if (splitCommand[0].isEmpty()) {
            nameAndDate = splitCommand[1].split(" -e ");
        } else {
            nameAndDate = splitCommand[0].split(" -e ");
            String date = nameAndDate[1];
            String name = splitCommand[1];
            nameAndDate[0] = name;
            nameAndDate[1] = date;
        }
        return nameAndDate;
    }

}
