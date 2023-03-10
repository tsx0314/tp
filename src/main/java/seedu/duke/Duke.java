package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.DukeException;
import seedu.duke.food.FoodList;
import seedu.duke.general.Parser;
import seedu.duke.general.Ui;

import java.util.Scanner;

public class Duke {
    private Ui ui;
    private FoodList foodList;

    public Duke() {
        ui = new Ui();
        foodList = new FoodList();

    }

    //Code below adapted from https://nus-cs2113-ay2223s2.github.io/website/schedule/week7/project.html
    public void run() {

        ui.printOpeningMessage();
        boolean isExit = false;

        Scanner sc = new Scanner(System.in);

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(foodList, ui);
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

