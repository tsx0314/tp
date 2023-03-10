package seedu.duke.commands;

import seedu.duke.general.Ui;

public abstract class Command {
    protected String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public void execute(Ui ui) {
        ui.printExitLine();
    }

    public boolean isExit() {
        return false;
    }
}
