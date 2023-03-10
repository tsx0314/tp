package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandResult;
import seedu.duke.general.Parser;
import seedu.duke.general.Ui;

/**
 * Entry point of the Food Supply Tracker application
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
    private final Ui ui;

    public Duke() {
        ui = new Ui();

    }

    public void run() {

        ui.showWelcomeMessage();
        boolean isExit = false;

        while (!isExit) {

            String fullCommand = ui.readCommand();
            ui.showLine(); // show the divider line ("_______")
            Command c = Parser.parseCommand(fullCommand);
            CommandResult result = c.execute();
            ui.showResultToUser(result);
            isExit = c.isExit();

        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}

