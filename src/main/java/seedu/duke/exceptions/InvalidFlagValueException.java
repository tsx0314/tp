package seedu.duke.exceptions;
public class InvalidFlagValueException extends DukeException
{

    public InvalidFlagValueException(String flag) {
        this.errorMessage = "the value of flag " + "\"--" + flag + "\"" + " is invalid";
    }
}
