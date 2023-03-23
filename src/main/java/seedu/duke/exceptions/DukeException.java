package seedu.duke.exceptions;

public class DukeException extends Exception {

    protected String errorMessage = "Error..";


    public DukeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DukeException() {}
    public String getMessage() {
        return errorMessage;
    }

}
