package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelpCommandTest {

    @Test
    void HelpCommand_withSpaces_expectRemoveSpacing() {
        String input = "    help     ";
        HelpCommand hc = new HelpCommand(input);
        String[] expectedOutput = {"help"};
        assertArrayEquals(expectedOutput,hc.getFilters());
    }
    @Test
    void HelpCommand_multipleWithRegex_expectSeparateByRegex() {
        String input = "help--remove--find--add";
        HelpCommand hc = new HelpCommand(input);
        String[] expectedOutput = {"help", "remove", "find", "add"};
        assertArrayEquals(expectedOutput,hc.getFilters());
    }

    @Test
    void HelpCommand_withSpacesAndRegex_expectRemoveSpaceSeparateRegex() {
        String input = "help --   remove      --find--          add";
        HelpCommand hc = new HelpCommand(input);
        String[] expectedOutput = {"help", "remove", "find", "add"};
        assertArrayEquals(expectedOutput,hc.getFilters());
    }
}