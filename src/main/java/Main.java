import commands.Command;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Env;
import util.CommandsUtil;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        Env env = new Env();
        if(env.isHashNull()){
            System.out.println("Application should be stopped.");
            return;
        }

        String token = env.getEnv("DISCORD_API_TOKEN");

        System.out.println(token);
        if (token != null) {
            builder.setToken(token);
            builder.addEventListener(new Main());
            builder.buildAsync();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        String messageString =  event.getMessage().getContentRaw();

        //TODO get prefix on server
        String prefix = "!";
        if(!messageString.startsWith(prefix)) return;

        //"!ping bla"
        messageString = messageString.substring(prefix.length());

        String[] message = messageString.split(" ");

        System.out.println("We received a message of "
                + event.getAuthor().getName() + ": "
                + Arrays.toString(message)
        );

        Command command = CommandsUtil.getCommand(new ArrayList(Arrays.asList(message)));
        if(command != null) {
            String result = command.run(event);
            if(result!=null) event.getChannel().sendMessage(result).queue();
        }

    }

    private void help(MessageReceivedEvent event, String[] message) {
        String response;
        if(message.length==1){
            response = "Commands: \n"
            +"help: this page;\n"
            +"help musical: all commands from musical module\n";
        }
        else {
            switch(message[1].toUpperCase()) {
                case "MUSICAL":
                    response = "Commands: \n"
                    + "Musical module soon\n";
                    break;

                case "MOD":
                    response = "Commands: \n"
                            + "Moderator module soon\n";
                    break;
                case "ADMIN":
                    response = "Commands: \n"
                            + "Admin module soon\n";
                    break;
                default:
                    response = "None here";
                    break;
            }
        }
        event.getChannel().sendMessage(response).queue();
    }
}
