package seedu.duke;

public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        if (!fullCommand.equals("exit")) {
            throw new DukeException();
        }
        return new ExitCommand(fullCommand);
    }
}
