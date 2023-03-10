package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandResult;
<<<<<<< HEAD
import seedu.duke.general.Parser;
import seedu.duke.general.Ui;

=======
import seedu.duke.exceptions.DukeException;
import seedu.duke.food.FoodList;
import seedu.duke.general.Parser;
import seedu.duke.general.Ui;


>>>>>>> 32c778082d2042084c61e73d0801abd058c849e2
/**
 * Entry point of the Food Supply Tracker application
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
<<<<<<< HEAD
    private final Ui ui;
=======
    private Ui ui;
    private FoodList foodList;
>>>>>>> 32c778082d2042084c61e73d0801abd058c849e2

    public Duke() {
        ui = new Ui();
        foodList = new FoodList();

    }

    public void run() {

        ui.showWelcomeMessage();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                CommandResult result = c.execute(foodList);
                result.printResult();
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

