package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.model.Message;
import web.app.repository.MessageRepository;

import java.util.List;
@Transactional
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message addMessage(Message message){
        return  messageRepository.save(message);
    }

    public List<Message> allMessages(){
        return messageRepository.findAll();
    }


    public void deleteMessage(Long id){
      messageRepository.deleteMessageById(id);
    }
}
