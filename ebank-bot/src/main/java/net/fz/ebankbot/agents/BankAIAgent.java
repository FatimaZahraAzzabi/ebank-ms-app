
package net.fz.ebankbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class BankAIAgent {

    private final ChatClient chatClient;

    public BankAIAgent(
            ChatClient.Builder chatClient,
            ChatMemory chatMemory,
            ToolCallbackProvider tools) {

        this.chatClient = chatClient
                .defaultSystem("""
                         Tu es un assistant bancaire aimable et professionnel.
                        
                                                                               Règles :
                                                                               - Pour une salutation comme "Bonjour", réponds simplement par une salutation.
                                                                               - Pour une question générale, réponds directement sans appeler d'outil.
                                                                               - N'appelle aucun outil pour une simple salutation.
                                                                               - Utilise getAllCustomers uniquement si l'utilisateur demande la liste des clients.
                                                                               - Utilise findCustomerById uniquement si l'utilisateur demande les informations
                                                                                 d'un client précis et fournit son identifiant.
                                                                               - N'invente jamais les informations des clients.
            """)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .defaultTools(tools)
                .build();
    }

    public String chat(String query, String conversationId) {
        return chatClient.prompt()
                .user(query)
                .advisors(advisor -> advisor.param(
                        ChatMemory.CONVERSATION_ID, conversationId
                ))
                .call()
                .content();
    }
}
