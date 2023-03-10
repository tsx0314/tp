package seedu.duke.general;

import seedu.duke.commands.AddCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.exceptions.DukeException;

public class Parser {

    public static Command parse(String fullCommand) throws DukeException {
        fullCommand = fullCommand.trim();
        if (fullCommand.equals("exit")) {
            return new ExitCommand(fullCommand);
        } else if (fullCommand.startsWith("add")) {
            return new AddCommand(fullCommand);
        } else {
            throw new DukeException();

        }
    }


}
