package seedu.fst.general;

import java.util.Scanner;

/**
 * Text UI of the application
 */
public class Ui {

    public static final String LOGO_PATTERN = " ______              " +
            "_  _____                   _    _______             _             \n" +
            "|  ____|            | |/ ____|                 | |  |__   __|           | |            \n" +
            "| |__ ___   ___   __| | (___  _   _ _ __  _ __ | |_   _| |_ __ __ _  ___| | _____ _ __ \n" +
            "|  __/ _ \\ / _ \\ / _` |\\___ \\| | | | '_ \\| '_ \\| | | | | | '__/ _` |/ __| |/ / _ \\ '__|\n" +
            "| | | (_) | (_) | (_| |____) | |_| | |_) | |_) | | |_| | | | | (_| | (__|   <  __/ |   \n" +
            "|_|  \\___/ \\___/ \\__,_|_____/ \\__,_| .__/| .__/|_|\\__, |_|_|  \\__,_|\\___|_|\\_\\___|_|   \n" +
            "                                   | |   | |       __/ |                               \n" +
            "                                   |_|   |_|      |___/                                ";

    public Ui() {
    }

    /**
     * Reading in user input.
     *
     * @return user input
     */
    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        String fullInputLine = sc.nextLine();
        assert fullInputLine != null : "Input cannot be empty";
        return fullInputLine;
    }

    public void showWelcomeMessage() {
        System.out.println("Hello from\n" + LOGO_PATTERN);
        System.out.println("Hi! I am FoodSupplyTracker:)");
        System.out.println("Let us track expiry dates and combat food waste!");
        showLine();
    }

    public void showLine() {
        System.out.println("______________________________");
    }

    public static void showError(String message) {
        System.out.println(message);
    }


}
