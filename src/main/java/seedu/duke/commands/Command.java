package seedu.duke.commands;

import seedu.duke.exceptions.DukeException;
import seedu.duke.food.FoodList;

/**
 * Represents a Command class
 */
public abstract class Command {

    protected Command() {
    }

    public String outputToUser (FoodList foodList){
        String output ="";
        return output;
    }
    public CommandResult execute(FoodList foodList) throws DukeException {
        return new CommandResult("Duke is running");
    }

    public boolean isExit() {
        return false;
    }

}
