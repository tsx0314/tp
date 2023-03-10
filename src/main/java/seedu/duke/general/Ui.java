package seedu.duke.general;

import seedu.duke.commands.CommandResult;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Text UI of the application
 */
public class Ui {

    private static final String LOGO_PATTERN = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String LIST_MESSAGE = "Here is your food list!";

    private static final String ADD_MESSAGE = "Okay! I've added the product in the list :)";
    private static final String EXIT_MESSAGE = "Bye! Please consume your food ASAP :P";

    private final Scanner in;
    private final PrintStream out;

    public Ui(){
        this(System.in, System.out);
    }
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
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
    
    public void printExitLine() {
        System.out.println(EXIT_MESSAGE);
    }
    
    public void printListMessages() {
        System.out.println(LIST_MESSAGE);
    }

    public void printAddMessage() {
        System.out.println(ADD_MESSAGE);

    }
}
