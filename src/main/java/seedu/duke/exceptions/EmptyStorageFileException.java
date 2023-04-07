package seedu.duke.exceptions;

public class EmptyStorageFileException extends  DukeException{
    public EmptyStorageFileException() {
        super("File is empty.");
    }
}
