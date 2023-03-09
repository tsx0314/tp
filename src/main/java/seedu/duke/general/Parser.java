package seedu.duke.General;

import seedu.duke.Commands.Command;
import seedu.duke.Commands.ExitCommand;
import seedu.duke.Exceptions.DukeException;

public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        if (!fullCommand.equals("exit")) {
            throw new DukeException();
        }
        return new ExitCommand(fullCommand);
    }
}
