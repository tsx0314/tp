package seedu.duke.general;

import java.util.Scanner;

public class Ui {

    private static final String LOGO_PATTERN = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String LIST_MESSAGE = "Here is your food list!";

    private static final String ADD_MESSAGE = "Okay! I've added the product in the list :)";
    private static final String EXIT_MESSAGE = "Bye! Please consume your food ASAP :P";

    public Ui() {
    }

    public void printOpeningMessage() {
        System.out.println("Hello from\n" + LOGO_PATTERN);
        System.out.println("Hi! I am Duke:)");
        System.out.println("Let us track expiry dates and combat food waste!");
        showLine();
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void showLine() {
        System.out.println("______________________________");
    }

    public void printExitLine() {
        System.out.println(EXIT_MESSAGE);
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printListMessages() {
        System.out.println(LIST_MESSAGE);
    }

    public void printAddMessage() {
        System.out.println(ADD_MESSAGE);
    }
}
