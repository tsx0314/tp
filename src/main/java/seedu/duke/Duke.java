package seedu.duke;

import java.util.Scanner;

public class Duke {
	private Ui ui;
	public Duke() {
		ui = new Ui();

	}
	public void run() {
		ui.printOpeningMessage();
		boolean isExit = false;

		while (!isExit) {
			try {
				String fullCommand = ui.readCommand();
				ui.showLine(); // show the divider line ("_______")
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

