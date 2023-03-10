package seedu.duke.exceptions;

public class CommandException extends DukeException {
    private final String errorMessage = "Oops! I don't understand. Please use the correct command format:P";

    public String getMessage() {
        return errorMessage;
    }
}
