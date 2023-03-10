package seedu.duke.commands;

public class ExitCommand extends Command {
    public ExitCommand(String userInput) {
        super(userInput);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
