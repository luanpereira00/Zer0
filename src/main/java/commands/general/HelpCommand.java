package commands.general;

import commands.Command;
import commands.Result;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.ELanguage;
import util.TextContent;

import java.util.ArrayList;

public class HelpCommand extends Command {
    @Override
    public String help() {
        return this.getName();
    }

    @Override
    public String getName() {
        return HelpTextContent.HELP_DESCRIPTION.getName();
    }

    @Override
    public void addParameter(ArrayList<String> message) {
        System.out.println(message);
    }

    @Override
    public String run(MessageReceivedEvent event, ELanguage language) {
        return help();
    }

    /*
     * Text Contents of ping command
     */
    public enum HelpTextContent implements TextContent {
        HELP_DESCRIPTION("COMMAND_HELP_DESCRIPTION"),
        HELP_RESPONSE("COMMAND_HELP_RESPONSE");

        private String displayName;

        HelpTextContent(String displayName) {
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
}
