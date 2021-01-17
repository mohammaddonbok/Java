package com.mvc.tvshows.services;

import com.mvc.tvshows.models.Rate;
import com.mvc.tvshows.models.Show;
import com.mvc.tvshows.models.User;
import com.mvc.tvshows.repositories.RateRepository;
import com.mvc.tvshows.repositories.ShowRepository;
import com.mvc.tvshows.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Services {
    private final RateRepository rateRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    public Services(RateRepository rateRepository, ShowRepository showRepository, UserRepository userRepository) {
        this.rateRepository = rateRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
    }
    public Rate create(Rate rate) {
        return rateRepository.save(rate);
    }

    public Show create(Show show) {

        return showRepository.save(show);
    }

    public Show update(Show show) {
        return showRepository.save(show);
    }

    public List<Show> findAll() {
        return showRepository.findAll();
    }

    public Show findOneById(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);

        if(optionalShow.isPresent()) {
            return optionalShow.get();
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        if(optionalShow.isPresent()) {
            showRepository.deleteById(id);
        } else {
            System.out.println("Show does not exist");
        }

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
        } else {
            return null;
        }
    }
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password,  user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
