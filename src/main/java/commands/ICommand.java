package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public interface ICommand {

    public abstract Result help();

    public abstract List<Command> getSubcommands();

    public abstract String getName();

    public abstract List<String> getAliases();

    public abstract void addParameter(ArrayList<String> message);

    public abstract boolean requireParameter();

    public abstract String run(MessageReceivedEvent event);
}
