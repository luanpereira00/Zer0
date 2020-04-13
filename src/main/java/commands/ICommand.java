package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.ELanguage;

import java.util.ArrayList;
import java.util.List;

/*
* Defines an interface with all methods a command HAVE TO implement
*/
public interface ICommand {

    /*
    * Returns the help of command
    */
    //TODO Return as Result Class
    public abstract String help();

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
    * true if a method has parameter, either OPTIONAL or REQUIRED, false otherwise
    */
    public abstract boolean hasParameter();

    /*
    * A method to execute an action
    *
    * @param event the event which invokes this action
    * @param language the server language
    */
    public abstract String run(MessageReceivedEvent event, ELanguage language);
}
