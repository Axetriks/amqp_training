package fr.lernejo.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageController {
    
    ChatMessageListener chat;

    public ChatMessageController(@Autowired ChatMessageListener chat){
        this.chat = chat;
    }

    @RequestMapping(value = "/api/message", method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getMessage(){
        return new ResponseEntity<>(this.chat.repo.getLastTenMessages(), HttpStatus.OK);
    }

}
