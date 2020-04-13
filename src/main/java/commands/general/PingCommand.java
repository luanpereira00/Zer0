package commands.general;
import commands.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.ELanguage;
import util.JSONManager;
import util.TextContent;

import java.util.ArrayList;

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
    }

    //Not implemented yet
    @Override
    public String help() {
        return PingTextContent.PING_DESCRIPTION.getName();
    }

    /*
    * Return the name of this Command via EnumerationCommand
    */
    @Override
    public String getName() {
        return ECommand.PING.getName();
    }

    //Not implemented yet
    @Override
    public void addParameter(ArrayList<String> message) {
        return;
    }

    /*
    * Implements run method
    */
    @Override
    public String run(MessageReceivedEvent event, ELanguage serverLanguage) {
        //TODO Redo schema of JSONs file to have parameters on strings like 'some text %s text bla bla '
        String first_element = JSONManager.getInstance().getTextContent(serverLanguage, getCommandModule(), PingTextContent.PING_RESPONSE_FIRST);
        String second_element = JSONManager.getInstance().getTextContent(serverLanguage, getCommandModule(), PingTextContent.PING_RESPONSE_SECOND);
        return first_element + " " + ping(event) + " " + second_element;
    }

    /*
    * Text Contents of ping command
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
