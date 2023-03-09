package seedu.duke;

import java.util.Scanner;

public class Ui {

    public Ui() {
    }

    private final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public void printOpeningMessage() {
        System.out.println("Hello from\n" + LOGO);
        System.out.println("Hi! I am Duke:)\n" +
                "Let us track expiry dates and combat food waste together! ");
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void showLine() {
        System.out.println("___________________________________");
    }

    public void printExitLine() {
        System.out.println("BYE!");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
