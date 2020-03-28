package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class Command implements ICommand {
    protected List aliases;
    protected CommandCategory commandCategory;
    protected String description;
    protected Integer cooldown;
    protected String usage;



    //TODO private final Permissions permissions;
    //TODO private final Map<String, SubCommand> subCommandAssociations = new HashMap<>();
    //TODO private final CommandLineParser cliParser = new DefaultParser();

    protected Command(){
        aliases = null;
        commandCategory = null;
        description = null;
        cooldown = null;
    }

    protected Command(List<String> aliases, CommandCategory commandCategory, String description, Integer cooldown){
        setAliases(aliases);
        setCommandCategory(commandCategory);
        setDescription(description);
        setCooldown(cooldown);
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public CommandCategory getCommandCategory() {
        return commandCategory;
    }

    public void setCommandCategory(CommandCategory commandCategory) {
        this.commandCategory = commandCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String run(MessageReceivedEvent event){
        return null;
    }
}
