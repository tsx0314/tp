package seedu.duke.commands;

<<<<<<< HEAD
=======
import seedu.duke.food.FoodList;

>>>>>>> 32c778082d2042084c61e73d0801abd058c849e2
public abstract class Command {

    protected Command() {
    }

    public CommandResult execute(FoodList foodList) {
        return new CommandResult("Duke is running");
    }

    public boolean isExit() {
        return false;
    }
}
