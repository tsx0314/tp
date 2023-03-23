package seedu.duke.commands;

import seedu.duke.food.FoodList;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String SHOW_FOODLIST_MESSAGE = "Below are the food list: \n";
    public static final String REPORT_NUMBER_OF_FOOD_FRONT = "\nYou now have ";
    public static final String REPORT_NUMBER_OF_FOOD_BACK = " food products in your lists.";

    @Override
    public CommandResult execute(FoodList foodList) {
        int numberOfTask = foodList.getNumberOfFood();
        assert numberOfTask >= 0;

        if (numberOfTask > 0) {
            assert foodList instanceof FoodList && !foodList.getFoodList().isEmpty() :
                    "The list of food to be printed have to be a food list type and" +
                            "Food list cannot be empty.";
            System.out.println(SHOW_FOODLIST_MESSAGE);
            System.out.println(foodList);
        }
        return new CommandResult(REPORT_NUMBER_OF_FOOD_FRONT
                + numberOfTask + REPORT_NUMBER_OF_FOOD_BACK);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
