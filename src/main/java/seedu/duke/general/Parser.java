package seedu.duke.general;


import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.DukeException;

public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        if (!fullCommand.equals("exit")) {
            throw new DukeException();
        }
        return new ExitCommand(fullCommand);
    }
}
