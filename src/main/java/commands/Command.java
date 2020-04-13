package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import parameters.CommandParameter;
import parameters.ETypeParameter;

import java.util.ArrayList;
import java.util.List;

/*
* A class that represents commands fields
 */
public abstract class Command implements ICommand {
    protected List aliases; //aliases to this command - Is this necessary?
    protected CommandModule commandModule; //Which module this command is part of
    protected String description; //Description of this command - Is this necessary?
    protected Integer cooldown; //Cooldown of use
    protected String usage; //Example how to use - Is this necessary?
    protected ETypeParameter typeParameter; //If this command accepts parameters
    protected ArrayList<CommandParameter> parameters; //Parametes of this command when it has
    //TODO private final Permissions permissions

    protected Command(){
        setTypeParameter(ETypeParameter.UNUSED);
        setCooldown(5);
    }

    //Getter
    public ETypeParameter getTypeParameter() {
        return typeParameter;
    }

    //Setter
    protected void setTypeParameter(ETypeParameter typeParameter) {
        this.typeParameter = typeParameter;
    }

    public ArrayList<CommandParameter> getParameters() {
        return parameters;
    }

    protected void setParameters(ArrayList<CommandParameter> parameters) {
        this.parameters = parameters;
    }

    //getter
    public List<String> getAliases() {
        return aliases;
    }

    //setter
    protected void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    //getter
    public CommandModule getCommandModule() {
        return commandModule;
    }

    //setter
    protected void setCommandModule(CommandModule commandModule) {
        this.commandModule = commandModule;
    }

    //getter
    public String getDescription() {
        return description;
    }

    //setter
    protected void setDescription(String description) {
        this.description = description;
    }

    //getter
    public Integer getCooldown() {
        return cooldown;
    }

    //setter
    protected void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    //getter
    public String getUsage() {
        return usage;
    }

    //setter
    protected void setUsage(String usage) {
        this.usage = usage;
    }

    public boolean hasParameter() {
        return (getTypeParameter() == ETypeParameter.UNUSED ? false : true);
    }
}
