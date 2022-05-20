package web.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.app.model.Message;
import web.app.service.MessageService;

import java.util.List;

@RestController
public class MessageController {
    private final MessageService messageService ;
    private long counter = 0 ;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messages = messageService.allMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
    @PostMapping("/add")
        public ResponseEntity<Message> addMessage(@RequestBody Message message){
             this.counter++;
             message.setId(counter);
             if(message.getUsername().length() > 20){
                 return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
             }else{
             Message newMessage = messageService.addMessage(message);
             return new ResponseEntity<>(newMessage,HttpStatus.CREATED);
             }
        }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

