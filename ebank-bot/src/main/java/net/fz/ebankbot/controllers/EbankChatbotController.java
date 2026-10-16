package net.fz.ebankbot.controllers;

import net.fz.ebankbot.agents.BankAIAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EbankChatbotController {

    @Autowired
    private BankAIAgent bankAIAgent;



    @GetMapping(value = "/chat",produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(
            @RequestParam(name = "query", defaultValue = "Bonjour") String query,
            @RequestParam(name = "conversationId", defaultValue = "user-1") String conversationId) {

        return bankAIAgent.chat(query, conversationId);
    }
}
