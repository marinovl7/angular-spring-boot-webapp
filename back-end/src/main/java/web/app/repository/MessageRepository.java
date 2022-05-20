package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.model.Message;


public interface MessageRepository extends JpaRepository<Message,Long> {
    void deleteMessageById(Long id);
}
