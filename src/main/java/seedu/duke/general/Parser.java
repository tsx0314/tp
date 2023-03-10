package seedu.duke.general;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;

public class Parser {
    public static Command parseCommand(String fullCommand) {
        if (fullCommand.equals(ExitCommand.COMMAND_WORD)) {
            return new ExitCommand();
        }
        return null;
    }
}
