import commands.Command;
import commands.ELanguage;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Env;
import util.CommandsUtil;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;

/*
* Main class
*/
public class Zer0 extends ListenerAdapter {

    /*
    * Main method
    */
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        Env env = new Env();
        if(env.isHashNull()){
            System.out.println("Application should be stopped.");
            return;
        }

        String token = env.getEnv("DISCORD_API_TOKEN");

        if (token != null) {
            builder.setToken(token);
            builder.addEventListener(new Zer0());
            builder.buildAsync();
        }
    }

    /*
    * Event listener - on messages received
    * @param event The event which invokes this
    */
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        String messageString =  event.getMessage().getContentRaw();

        //TODO get prefix on server
        String prefix = "!";
        if(!messageString.startsWith(prefix)) return;

        messageString = messageString.substring(prefix.length());

        String[] message = messageString.split(" ");

        System.out.println("We received a message of "
                + event.getAuthor().getName() + ": "
                + Arrays.toString(message)
        );
        //TODO getServerLanguage
        ELanguage serverLanguage = ELanguage.EN_US;

        Command command = CommandsUtil.getCommand(new ArrayList(Arrays.asList(message)));
        if(command != null) {
            String result = command.run(event,serverLanguage);
            if(result!=null) event.getChannel().sendMessage(result).queue();
        }
    }
}
