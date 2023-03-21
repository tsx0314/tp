package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandResult;
import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidStorageFilePathException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.food.FoodList;
import seedu.duke.general.Parser;
import seedu.duke.general.Ui;
import seedu.duke.storage.StorageFile;

/**
 * Entry point of the Food Supply Tracker application
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {

    private Ui ui;
    private FoodList foodList;

    private StorageFile storageFile;

    //TODO: Remove the exceptions (handle them)
    public Duke() {
        ui = new Ui();
        try {
            storageFile = new StorageFile();
        } catch (InvalidStorageFilePathException e) {
        }

        try {
            foodList = storageFile.load();
        } catch (StorageOperationException e) {
        }
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
                storageFile.save(foodList);
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

