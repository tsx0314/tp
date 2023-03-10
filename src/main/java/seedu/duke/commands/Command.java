package seedu.duke.commands;

import seedu.duke.general.Ui;

public abstract class Command {
    //protected String userInput;
    //private int targetIndex = -1;

    protected Command(){
    }

    /*
    public void execute(Ui ui) {
        ui.printExitLine();
    }
    */

    public CommandResult execute(){
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
    
    public boolean isExit() {
        return false;
    }
}
