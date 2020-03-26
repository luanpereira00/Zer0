import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
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



        String prefix = "0";
        String[] message = event.getMessage().getContentRaw().split(" ");
        message[0] = message[0].toUpperCase();

        System.out.println("We received a message from "
                + event.getAuthor().getName() + ": "
                + Arrays.toString(message)
        );

        if (message[0].equals(prefix + "PING")) {
            ping(event);
        }

        if(message[0].equals(prefix + "HELP")){
            help(event, message);
        }

        /*if(message.equals(prefix + "SERVERINFO"))

        else {
            event.getChannel().sendMessage(event.getMessage()).queue();
        }*/

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

    private void ping(MessageReceivedEvent event) {
        String ping = Long.toString(event.getJDA().getPing());
        event.getChannel().sendMessage("Pong! Ping is " + ping + "ms.").queue();
    }
}
