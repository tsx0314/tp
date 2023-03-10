package seedu.duke.commands;

import seedu.duke.food.FoodList;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String SHOW_FOODLIST_MESSAGE = "Below are the food list: \n";
    public static final String REPORT_NUMBER_OF_FOOD_FRONT = "\nYou now have ";
    public static final String REPORT_NUMBER_OF_FOOD_BACK = " food products in your lists.";
    @Override
    public CommandResult execute (FoodList foodList){
        System.out.println(SHOW_FOODLIST_MESSAGE);
        for(int i = 0; i < foodList.getNumberOfFood(); ++i){
            System.out.println((i+1) + ". " + foodList.getFood(i).getName() + "\n       Expiry Date: "
                    + foodList.getFood(i).getExpiryDate() );
            System.lineSeparator();
        }
        return new CommandResult(REPORT_NUMBER_OF_FOOD_FRONT + foodList.getNumberOfFood()
                + REPORT_NUMBER_OF_FOOD_BACK);
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
