package commands;


import java.util.List;

public interface Command {

    String[] aliases = new String[0];
    CommandCategory commandCategory = null;
   //TODO private final Permissions permissions;
    String description = null;
    String usage = null;
    //TODO private final Map<String, SubCommand> subCommandAssociations = new HashMap<>();
    //TODO private final CommandLineParser cliParser = new DefaultParser();

    public Result help();

    public List<Command> getSubcommands();

    public String getName();

    public List<String> getAliases();
}
