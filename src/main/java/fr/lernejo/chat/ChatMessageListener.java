package fr.lernejo.chat;


import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    ChatMessageRepository repo;

    public ChatMessageListener(ChatMessageRepository repo){
        this.repo = repo;
    }

    public void onMessage(String message){

        repo.addChatMessage(message);
        System.out.println(repo.repo.get(repo.repo.indexOf(message)));
    }
}
