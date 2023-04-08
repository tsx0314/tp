package seedu.duke.exceptions;

public class ReadStorageFileErrorException extends  DukeException{
    public ReadStorageFileErrorException(String message) {
        super("The attribute '" + message + "' in the storage file is not valid.");
    }
}
