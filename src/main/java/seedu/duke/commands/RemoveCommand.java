package seedu.duke.commands;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.IllegalValueException;
import seedu.duke.food.FoodList;

public class RemoveCommand extends Command {
    public static final String COMMAND_WORD = "remove";

    public String index;

    public RemoveCommand(String index) {
        this.index = index;
    }

    public CommandResult execute (FoodList foodlist) throws DukeException {
        if (index.isBlank()) {
            throw new IllegalValueException("Incorrect value entered");
        }
        int deleteItem = Integer.parseInt(index.trim()) - 1;

        if (deleteItem >= foodlist.getNumberOfFood() || deleteItem < 0) {
            throw new IllegalValueException("Incorrect value entered");
        }
        String foodName = foodlist.getFood(deleteItem).getName();
        foodlist.removeFood(deleteItem);
        int itemsLeft = foodlist.getNumberOfFood();
        System.out.println("Removed " + foodName + " from the food supply list.");
        return new CommandResult("There is/are now " + itemsLeft + " item(s) in the list.");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
