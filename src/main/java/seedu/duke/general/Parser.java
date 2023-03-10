package seedu.duke.general;

import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.DukeException;

public class Parser {
    public static Command parseCommand(String fullCommand) {
        switch (fullCommand) {

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        default:
            return null;
        }
    }
}
