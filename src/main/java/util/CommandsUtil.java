package util;

import commands.Command;
import commands.ECommand;
import commands.general.*;

import java.util.ArrayList;

/*
* Implements methods util to commands
*/
public class CommandsUtil {

    /*
    * Finds the method passed in a message - params are optional
    *
    * @param message The message that invokes listener
    * @return the command recognized - null if nothing
    */
    public static Command getCommand(ArrayList<String> message) {
        ECommand eCommand;
        if(message != null && message.get(0) != null) {
            eCommand = CommandsUtil.getECommand(message.get(0));
        } else {
            eCommand = CommandsUtil.getECommand("ERROR");
        }
        Command command = CommandsUtil.getCommandByEnum(eCommand);

        if(command != null && command.requireParameter()){
            message.remove(0);
            command.addParameter(message);
        }
        return command;
    }

    /*
    * returns a command when passing the enumeration of commands
    *
    * @param eCommand enumeration of commands
    * @return the command recognized by bot
    */
    private static Command getCommandByEnum(ECommand eCommand){
        return CommandsUtil.createCommand(eCommand);
    }

    /*
    * Creates a command using an enum passed by param
    *
    * @param eCommand enumeration of commands
    * @return new Instance of command
    */
    private static Command createCommand(ECommand eCommand) {
        switch(eCommand){
            case PING:
                return new PingCommand();
            default:
                return null;
        }
    }

    /*
    * instantiate a enumeration of command
    *
    * @param command string with the command to interpret as enum
    * @return the command interpreted by bot - ERROR if no mapped or default
    */
    private static ECommand getECommand(String command){
        ECommand ecommand = null;
        //TODO dictionary to aliases commands
        try {
            ecommand = ECommand.valueOf(command.toUpperCase());
            System.out.println("Command identified is " + ecommand.getName());
        } catch(IllegalArgumentException e){
            ecommand = ECommand.valueOf("ERROR");
        }
        return ecommand;
    }
}
