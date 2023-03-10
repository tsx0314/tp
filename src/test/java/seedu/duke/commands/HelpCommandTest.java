package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HelpCommandTest {

    @Test
    void HelpCommand_withSpaces_expectRemoveSpacing() {
        String input = "    help     ";
        HelpCommand hc = new HelpCommand(input);
        String[] expectedOutput = {"help"};
        assertArrayEquals(expectedOutput,hc.getFilters());
    }
    @Test
    void helpCommand_multipleWithRegex_expectSeparateByRegex() {
        String input = "help--remove--find--add";
        HelpCommand hc = new HelpCommand(input);
        String[] expectedOutput = {"help", "remove", "find", "add"};
        assertArrayEquals(expectedOutput,hc.getFilters());
    }

    @Test
    void helpCommand_withSpacesAndRegex_expectRemoveSpaceSeparateRegex() {
        String input = "help --   remove      --find--          add";
        HelpCommand hc = new HelpCommand(input);
        String[] expectedOutput = {"help", "remove", "find", "add"};
        assertArrayEquals(expectedOutput,hc.getFilters());
    }
}
