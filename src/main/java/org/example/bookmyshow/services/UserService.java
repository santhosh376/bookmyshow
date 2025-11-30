package org.example.bookmyshow.services;

import org.example.bookmyshow.exception.NoUserFound;
import org.example.bookmyshow.model.User;
import org.example.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(NoUserFound::new);
    }

    public User registerUser(String name,String email,String password){
        User newUser = User.builder().name(name).email(email).password(password).build();
        userRepository.save(newUser);
        return newUser;
    }
}
