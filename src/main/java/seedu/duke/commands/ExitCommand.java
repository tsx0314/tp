package seedu.duke.commands;

public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "exit";
    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Food Supply Tracker as requested ...";

    @Override
    public CommandResult execute(){
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT);
    }

    public boolean isExit() {
        return true;
    }
}
