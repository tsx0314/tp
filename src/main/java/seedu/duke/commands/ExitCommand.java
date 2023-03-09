package seedu.duke.Commands;

public class ExitCommand extends Command {
    public ExitCommand(String userInput) {
        super(userInput);
    }

    public boolean isExit() {
        return true;
    }
}
