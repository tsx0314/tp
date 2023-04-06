package seedu.duke.utils;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.IllegalValueException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateFormatter {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static LocalDate parse(String date) throws DukeException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new DukeException("Invalid date provided");
        }
    }
    public void checkValidDate(String date) throws DukeException {
        try {
            LocalDate expiryDate = LocalDate.parse(date, formatter);
            if (expiryDate.isBefore(LocalDate.now())){
                throw new IllegalValueException("Please input a valid  date :<");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalValueException("Please input a valid  date :<\"");
        }
    }


}
