package util;

import commands.Command;
import commands.ICommand;
import commands.ECommand;
import commands.general.*;

import java.util.ArrayList;

public class CommandsUtil {
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

    private static Command getCommandByEnum(ECommand eCommand){
        return CommandsUtil.createCommand(eCommand);
    }

    private static Command createCommand(ECommand eCommand) {
        switch(eCommand){
            case PING:
                return new PingCommand();
            default:
                return null;
        }
    }

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
