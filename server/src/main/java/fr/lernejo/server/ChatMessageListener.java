package fr.lernejo.server;


import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    public ChatMessageRepository repo;

    public ChatMessageListener(ChatMessageRepository repo){
        this.repo = repo;
    }

    public void onMessage(String message){

        repo.addChatMessage(message);
    }
}
