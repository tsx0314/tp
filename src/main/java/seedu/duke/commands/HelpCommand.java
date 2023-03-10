package seedu.duke.commands;

import seedu.duke.general.Ui;

public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";
    private String[] filters;
    public HelpCommand (String userInput) {
        filters = userInput.split("--");
        processHelpCommand(filters);
    }

    private void processHelpCommand(String[] filters) {
        if (filters.length == 1) {
            printAllCommands();
            printDefaultHelp();
        }

        for (String f : filters) {
            f = f.trim();

            if (f.equals(COMMAND_WORD) || f.equals("")) {
                continue;
            }

            switch (f) {
            case ExitCommand.COMMAND_WORD:
                printHelpExit();
                break;
            case ListCommand.COMMAND_WORD:
                printHelpList();
                break;
            case AddCommand.COMMAND_WORD:
                printHelpAdd();
                break;
            case RemoveCommand.COMMAND_WORD:
                printHelpRemove();
                break;
            case FindCommand.COMMAND_WORD:
                printHelpFind();
                break;
            default:
                System.out.println("Opps! The input " + f + " is invalid.");
            }
        }
    }

    private void printAllCommands() {
        System.out.println("List of commands: 'bye', 'help', 'list', 'add', 'remove', 'find'"
                + "\nFor more detailed information on usage of specific command, type: help --COMMAND");
    }

    private void printDefaultHelp() {
        System.out.println("Refer to our user guide for more in-depth details on how to use our system:"
                + "\nhttps://docs.google.com/document/d/1WKscnkYy9UqI_tsWmUHIMjgILJc6GQeFn0B1ce6qkQo/edit?usp=sharing");
    }

    private void printHelpExit() {
        System.out.println("Command 'exit': This command is used to exit the program.\n");
    }

    private void printHelpList() {
        System.out.println("Command 'list': This command lists all food products in the tracker."
                + "\nAppend the filter '--fresh' for listing unexpired food products and" +
                "'--expired' for listing expired food products.\n");
    }

    private void printHelpAdd() {
        System.out.println("Command 'add': This command adds a food product to the food supply tracker."
                + "\nFormat: add -n PRODUCT_NAME -e EXPIRY_DATE\n");
    }

    private void printHelpRemove() {
        System.out.println("Command 'remove': This command removes the food product from the food supply tracker"
                + " based on its index." + "\nFormat: remove INDEX\n");
    }

    private void printHelpFind() {
        System.out.println("Command 'find': This command finds the food product by its name."
                + "\nFormat: find PRODUCT_NAME\n");
    }
}

