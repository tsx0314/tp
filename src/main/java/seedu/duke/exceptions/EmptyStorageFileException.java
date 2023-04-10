package seedu.duke.exceptions;


public class EmptyStorageFileException extends  DukeException{
    public EmptyStorageFileException() {
        super("Line in storage file is empty. Data may be corrupted.");
    }
}
