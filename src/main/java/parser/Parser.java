package parser;

import command.CommandType;
import command.Command;
import command.AddCommand;
import command.ExitCommand;
import command.HelpCommand;
import command.ListCommand;
import command.ModifyCommand;
import command.SearchCommand;
import error.DukeException;
import error.UnrecognizedException;


public class Parser {
    /**
     * Parser to read user input
     *
     * @param input users input message
     * @return type of command
     * @throws UnrecognizedException if action is not a recognized command
     * @throws DukeException         if format has a "|" which will conflict with save format
     */
    public Command parse(String input) throws UnrecognizedException, DukeException {
        if (input.contains("|")) {
            throw new DukeException("INPUT_FORMAT_ERROR");
        }
        String action;
        String[] inputArray;
        inputArray = input.split(" ", 2);
        action = inputArray[0].toLowerCase();
        CommandType commandType = CommandType.getCommandType(action);
        switch (commandType) {
        case BYE:
            return new ExitCommand();
        case TODO:
        case DEADLINE:
        case EVENT:
            return new AddCommand(commandType, inputArray[1]);
        case DELETE:
        case DONE:
            return new ModifyCommand(commandType, inputArray[1]);
        case LIST:
            return new ListCommand();
        case FIND:
        case VIEW:
            return new SearchCommand(commandType, inputArray[1]);
        case HELP:
            return new HelpCommand();
        default:
            assert false:commandType;
            throw new UnrecognizedException();
        }
    }
}
