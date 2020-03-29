package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

/*
* Defines an interface with all methods a command HAVE TO implement
*/
public interface ICommand {

    /*
    * Returns the help of command
    */
    public abstract Result help();

    /*
    * Returns a list of subcommands
    */
    public abstract List<Command> getSubcommands();

    /*
    * Returns name of command
    */
    public abstract String getName();

    /*
    * Returns all aliases of this command
    */
    public abstract List<String> getAliases();

    /*
    * A method to populate fields in command with all parameter setted by user
    */
    public abstract void addParameter(ArrayList<String> message);

    /*
    * true if a method require parameter, false otherwise
    */
    public abstract boolean requireParameter();

    /*
    * A method to execute an action
    *
    * @param event the event which invokes this action
    * @param language the server language
    */
    public abstract String run(MessageReceivedEvent event, ELanguage language);
}
