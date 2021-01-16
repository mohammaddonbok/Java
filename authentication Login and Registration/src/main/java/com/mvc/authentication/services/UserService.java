package com.mvc.authentication.services;
import com.mvc.authentication.models.Event;
import com.mvc.authentication.models.Message;
import com.mvc.authentication.models.User;
import com.mvc.authentication.repositories.EventsRepository;
import com.mvc.authentication.repositories.MessageRepositry;
import com.mvc.authentication.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventsRepository eventRepository;
    private final MessageRepositry messageRepositry;

    public UserService(UserRepository userRepository, EventsRepository eventRepository,
                       MessageRepositry messageRepositry) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.messageRepositry = messageRepositry;
    }

    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(Long id) {
        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()) {
            return u.get();
        }
        else {
            return null;
        }
    }

    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public List<User> allUser() {
        return userRepository.findAll();
    }

    public List <Event> allEvents() {
        return eventRepository.findAll();
    }

    public List <Message> allComments() {
        return messageRepositry.findAll();
    }

    public Event findEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);

        if(event.isPresent()) {
            return event.get();
        }
        else {
            return null;
        }
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Message createComment(Message comment) {
        return messageRepositry.save(comment);
    }

    public void deleteEvent(Event event) {
        List<Message> messages=event.getComments();
        for(Message message:messages){
            messageRepositry.deleteById(message.getId());
        }
        eventRepository.delete(event);
    }
}