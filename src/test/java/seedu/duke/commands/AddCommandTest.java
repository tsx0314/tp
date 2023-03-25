package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    @Test
    void testSplitDetails_oneString_returnsStringsArrayInTwoParts() {
        String details = " -n Egg -e 21/03/2023";
        AddCommand addFood = new AddCommand(details);
        String[] expected = {"Egg", "21/03/2023"};
        assertArrayEquals(expected, addFood.splitDetails(details));
    }

    @Test
    void testSplitDetails_oneString_returnsStringsArrayInThreeParts() {
        String details = " -n Egg -e 21/03/2023 -q 10";
        AddCommand addFood = new AddCommand(details);
        String[] expected = {"Egg", "21/03/2023", "10"};
        assertArrayEquals(expected, addFood.splitDetails(details));
    }

    @Test
    void testSplitDetails_oneStringWithNamedAndDateInDifferentOrder_returnsStringsArrayInTwoParts() {
        String details = " -e 21/03/2023 -n egg -q 10";
        AddCommand addFood = new AddCommand(details);
        String[] expected = {"egg", "21/03/2023", "10"};
        assertArrayEquals(expected, addFood.splitDetails(details));
    }


    @Test
    void testSplitDetails_oneStringWithAllElements_returnsStringsArrayInFourParts() {
        String details = " -e 21/03/2023       -n egg -q      10    -u kg";
        AddCommand addFood = new AddCommand(details);
        String[] expected = {"egg", "21/03/2023", "10","kg"};
        assertArrayEquals(expected, addFood.splitDetails(details));
    }

    @Test
    void testIsValidDate_validDate_returnsTrue() {
        String details = " -e 21/09/2023 -n egg -q 10";
        AddCommand addFood = new AddCommand(details);
        String date = addFood.splitDetails(details)[1];
        boolean expected = true;
        assertEquals(expected, addFood.isValidDate(date));
    }

    @Test
    void testIsValidDate_invalidDate_returnsFalse() {
        String details = " -e 21/14/2023 -n egg -q 10";
        AddCommand addFood = new AddCommand(details);
        String date = addFood.splitDetails(details)[1];
        boolean expected = false;
        assertEquals(expected, addFood.isValidDate(date));
    }

}
