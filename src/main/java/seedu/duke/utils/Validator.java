package seedu.duke.utils;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.IllegalValueException;
import seedu.duke.food.Unit;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validator {

    public static boolean isExpiryDateValid(String date) throws DukeException {
        try {
            LocalDate expiryDate = LocalDate.parse(date, DateFormatter.formatter);
            if (expiryDate.isBefore(LocalDate.now())){
                throw new IllegalValueException("Provided date is not in the future");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalValueException("Date is not valid");
        }
        return true;
    }
    public static boolean isQuantityValid(Double q) throws DukeException {
        if ( q < 0 || q > 9999  ) {
            throw new DukeException("Quantity is not valid");
        }
        return true;
    }

    public static boolean isUnitValid(String unitName) throws DukeException {
        for (Unit u: Unit.values()) {
            if (u.abbreviation.equals(unitName)) {
                return true;
            }
        }
        throw new DukeException("Unit is not valid");
    }
}
