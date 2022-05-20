package web.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String text;
    @Column(nullable = false,updatable = false)
    private String username;

    public Message(String username,String text){
        this.username=username;
        this.text=text;

    }

    public Message() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString(){
        return "Message:{\n" + "text= " + text + ",\n" +
                "username=" + username + ",\n"  +
                "id=" + id + "\n" + "}";
    }
}
