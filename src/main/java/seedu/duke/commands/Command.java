package seedu.duke.commands;

import seedu.duke.exceptions.DukeException;
import seedu.duke.food.FoodList;
import seedu.duke.general.Ui;

public abstract class Command {
    //protected String userInput;
    //private int targetIndex = -1;

    protected Command(){
    }

    public void execute(FoodList foodList, Ui ui) throws DukeException {

        ui.printExitLine();
    }

    public CommandResult execute(){
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
    
    public boolean isExit() {
        return false;
    }
}
