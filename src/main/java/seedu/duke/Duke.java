package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandResult;
import seedu.duke.exceptions.DukeException;
import seedu.duke.general.Parser;
import seedu.duke.general.Ui;

import java.util.Scanner;

/**
 * Entry point of the Food Supply Tracker application
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
    private Ui ui;

    public Duke() {
        ui = new Ui();

    }

    //Code below adapted from https://nus-cs2113-ay2223s2.github.io/website/schedule/week7/project.html
    public void run() {

        ui.showWelcomeMessage();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parseCommand(fullCommand);
                CommandResult result = c.execute();
                ui.showResultToUser(result);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}

