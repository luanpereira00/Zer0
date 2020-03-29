package commands.general;
import commands.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.JSONManager;

import java.util.ArrayList;
import java.util.List;

/*
* Defines how a command named Ping will work
*
* Extends Command and Implements InterfaceCommand
*/
public class PingCommand  extends Command {
    /*
    * Default constructor
    */
    public PingCommand(){
        setCommandModule(CommandModule.GENERAL);
        setCooldown(5);
    }

    //Not implemented yet
    @Override
    public Result help() {
        return null;
    }

    //Not implemented yet
    @Override
    public List<Command> getSubcommands() {
        return null;
    }

    /*
    * Return the name of this Command via EnumerationCommand
    */
    @Override
    public String getName() {
        return ECommand.PING.name();
    }

    //Not implemented yet
    @Override
    public void addParameter(ArrayList<String> message) {
        return;
    }

    //Not implemented yet
    @Override
    public boolean requireParameter() {
        return false;
    }

    /*
    * Implements run method
    */
    @Override
    public String run(MessageReceivedEvent event, ELanguage serverLanguage) {
        String first_element = JSONManager.getInstance().getTextContent(serverLanguage, getCommandModule(), PingTextContent.PING_RESPONSE_FIRST);
        String second_element = JSONManager.getInstance().getTextContent(serverLanguage, getCommandModule(), PingTextContent.PING_RESPONSE_SECOND);
        return first_element + " " + ping(event) + " " + second_element;
    }

    /*
    * Text Contents of bot
    */
    public enum PingTextContent implements TextContent {
        PING_DESCRIPTION("COMMAND_PING_DESCRIPTION"),
        PING_RESPONSE_FIRST("COMMAND_PING_RESPONSE_FIRST"),
        PING_RESPONSE_SECOND("COMMAND_PING_RESPONSE_SECOND");

        private String displayName;

        PingTextContent(String displayName) {
            this.displayName = displayName;
        }

        /*
        * Returns ENUM value
        */
        @Override
        public String getName(){
            return this.toString();
        }
    };

    /*
    * Run discord event ping
    * @value event The Event which invokes that
    *
    * @return the result (in ms.) as String
    */
    private String ping(MessageReceivedEvent event) {
        return Long.toString(event.getJDA().getPing());
    }
}
