package seedu.duke.exceptions;

public class DukeException extends Exception {
    private String errorMessage;

    DukeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }

}
