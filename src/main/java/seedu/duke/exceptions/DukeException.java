package seedu.duke.Exceptions;

public class DukeException extends Exception {
    private final String errorMessage = "Error..";

    public String getMessage() {
        return errorMessage;
    }

}
