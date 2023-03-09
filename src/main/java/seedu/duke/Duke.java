package seedu.duke;

import java.util.Scanner;

public class Duke {
    private Ui ui;

    public Duke() {
        ui = new Ui();

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
                c.execute(ui);
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

