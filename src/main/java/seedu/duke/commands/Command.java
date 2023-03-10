package seedu.duke.commands;

import seedu.duke.exceptions.DukeException;
import seedu.duke.food.FoodList;
import seedu.duke.general.Ui;

public abstract class Command {
    protected String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public void execute(FoodList foodList, Ui ui) throws DukeException {
        ui.printExitLine();
    }

    public boolean isExit() {
        return false;
    }
}
