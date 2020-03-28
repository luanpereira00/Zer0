package commands.general;
import commands.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class PingCommand  extends Command {
    public PingCommand(){
        //super(List aliases, CommandCategory commandCategory, String description, Integer cooldown);
        super(null, CommandCategory.GENERAL, "Ping the bot",3);
    }

    @Override
    public Result help() {
        return null;
    }

    @Override
    public List<Command> getSubcommands() {
        return null;
    }

    @Override
    public String getName() {
        return ECommand.PING.name();
    }

    @Override
    public void addParameter(ArrayList<String> message) {
        return;
    }

    @Override
    public boolean requireParameter() {
        return false;
    }

    @Override
    public String run(MessageReceivedEvent event){
        return "Pong! Ping is " + ping(event) + "ms.";
    }

    private String ping(MessageReceivedEvent event) {
        return Long.toString(event.getJDA().getPing());
    }
}
