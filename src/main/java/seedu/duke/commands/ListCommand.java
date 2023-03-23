package seedu.duke.commands;

import seedu.duke.food.FoodList;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String SHOW_FOODLIST_MESSAGE = "Below are the food list: \n";
    public static final String REPORT_NUMBER_OF_FOOD_FRONT = "\nYou now have ";
    public static final String REPORT_NUMBER_OF_FOOD_BACK = " food products in your lists.";

    @Override
    public CommandResult execute(FoodList foodList) {
        String printToUser = "";
        int numberOfFood = foodList.getNumberOfFood();
        assert numberOfFood >= 0;

        if (numberOfFood > 0) {
            assert foodList instanceof FoodList && !foodList.getFoodList().isEmpty() :
                    "The list of food to be printed have to be a food list type and" +
                            "Food list cannot be empty.";
            printToUser = printToUser.concat(SHOW_FOODLIST_MESSAGE);
            for(int index = 0; index < numberOfFood; ++index){
                printToUser = printToUser.concat((index+1) + ". " + foodList.getFood(index).getName()
                    + "\n   Expiry date: " + foodList.getFood(index).getExpiryDate() + "\n");
            }
        }
        printToUser = printToUser.concat(REPORT_NUMBER_OF_FOOD_FRONT
                + numberOfFood + REPORT_NUMBER_OF_FOOD_BACK);
        return new CommandResult(printToUser);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
