package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

/*
* A class that represents commands fields
 */
public abstract class Command implements ICommand {
    protected List aliases;
    protected CommandModule commandModule;
    protected String description;
    protected Integer cooldown;
    protected String usage;

    //TODO private final Permissions permissions;
    //TODO private final Map<String, SubCommand> subCommandAssociations = new HashMap<>();
    //TODO private final CommandLineParser cliParser = new DefaultParser();

    //getter
    public List<String> getAliases() {
        return aliases;
    }

    //setter
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    //getter
    public CommandModule getCommandModule() {
        return commandModule;
    }

    //setter
    public void setCommandModule(CommandModule commandModule) {
        this.commandModule = commandModule;
    }

    //getter
    public String getDescription() {
        return description;
    }

    //setter
    public void setDescription(String description) {
        this.description = description;
    }

    //getter
    public Integer getCooldown() {
        return cooldown;
    }

    //setter
    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    //getter
    public String getUsage() {
        return usage;
    }

    //setter
    public void setUsage(String usage) {
        this.usage = usage;
    }
}
