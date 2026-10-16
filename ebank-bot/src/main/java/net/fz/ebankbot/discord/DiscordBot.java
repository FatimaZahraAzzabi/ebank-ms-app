package net.fz.ebankbot.discord;
import com.zgamelogic.discord.annotations.DiscordMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.fz.ebankbot.agents.BankAIAgent;
import com.zgamelogic.discord.annotations.DiscordController;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;

@DiscordController
public class DiscordBot {
    @Autowired
    private BankAIAgent bankAIAgent;

    @DiscordMapping
    private void perform(MessageReceivedEvent event) {
        System.out.println(event);
        if (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String response = bankAIAgent.chat(query,"user1");
        event.getChannel().sendMessage(response).queue();
    }
}
