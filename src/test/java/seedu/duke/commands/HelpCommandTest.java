package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import seedu.duke.exceptions.DukeException;
import seedu.duke.food.FoodList;
import seedu.duke.general.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HelpCommandTest {
    private FoodList foodList;
    private static final String SHOW_ALL_COMMANDS = "List of commands: 'exit', 'help', 'list', 'add', 'remove', "
            + "'find', 'update'."
            + "\nFor more detailed information on usage of specific command, type: help --COMMAND";
    private static final String DEFAULT_HELP_MESSAGE = "Refer to our user guide for more in-depth details on"
            + " how to use our system:"
            + "\nhttps://docs.google.com/document/d/1WKscnkYy9UqI_tsWmUHIMjgILJc6GQeFn0B1ce6qkQo/edit?usp=sharing";
    @Test
    void helpCommand_multipleWithRegex_expectSeparateByRegex() {
        String input = "--remove--find--add";
        HelpCommand hc = new HelpCommand(input);
        HashSet<String> expectedOutput = new HashSet<>();
        expectedOutput.addAll(List.of(new String[]{"", "remove", "find", "add"}));
        assertTrue(expectedOutput.equals(hc.getFilters()));

    }

    @Test
    void helpCommand_withSpacesAndRegex_expectRemoveSpaceSeparateRegex() {
        String input = " --   remove      --find--          add";
        HelpCommand hc = new HelpCommand(input);
        HashSet<String> expectedOutput = new HashSet<>();
        expectedOutput.addAll(List.of(new String[]{"", "remove", "find", "add"}));
        assertTrue(expectedOutput.equals(hc.getFilters()));
    }

    @Test
    void commandResult_withFilterButNoCommand_expectDefaultMessage() {
        String input = "help --";

        Command c = Parser.parse(input);
        try {
            CommandResult result = c.execute(foodList);
            String expectedOutput = SHOW_ALL_COMMANDS + '\n' + DEFAULT_HELP_MESSAGE;
            assertEquals(expectedOutput, result.feedbackToUser);
        } catch (DukeException e) {
            assert false;
            System.out.println("Unexpected Error");
        }
    }
}
