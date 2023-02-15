package fr.lernejo.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class ChatMessageRepository {

    public List<String> repo;

    public ChatMessageRepository(){
        this.repo = new ArrayList<String>();
    }
    void addChatMessage(String message){
        this.repo.add(message);
    }

    List<String> getLastTenMessages(){
        List<String> myLastMessages;
        if(this.repo.size()>10){
            myLastMessages = this.repo.subList(this.repo.size()-10, this.repo.size());
        }else myLastMessages = this.repo;
        return myLastMessages;
    }
}
