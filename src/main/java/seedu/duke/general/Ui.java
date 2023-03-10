package seedu.duke.general;

<<<<<<< HEAD
import seedu.duke.commands.CommandResult;

import java.io.InputStream;
import java.io.PrintStream;
=======
>>>>>>> 32c778082d2042084c61e73d0801abd058c849e2
import java.util.Scanner;

/**
 * Text UI of the application
 */
public class Ui {

    public static final String LOGO_PATTERN = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    public static final String LIST_MESSAGE = "Here is your food list!";

    public Ui() {
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        String fullInputLine = sc.nextLine();
        return fullInputLine;
    }

    public void showWelcomeMessage() {
        System.out.println("Hello from\n" + LOGO_PATTERN);
        System.out.println("Hi! I am Duke:)");
        System.out.println("Let us track expiry dates and combat food waste!");
        showLine();
    }

    public void showLine() {
        System.out.println("______________________________");
    }

<<<<<<< HEAD
    public void showResultToUser(CommandResult result){
        System.out.println(result.feedbackToUser);
=======

    public void showError(String message) {
        System.out.println(message);
>>>>>>> 32c778082d2042084c61e73d0801abd058c849e2
    }
}
