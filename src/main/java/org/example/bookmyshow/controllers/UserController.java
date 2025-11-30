package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.RegisterUserRequestDto;
import org.example.bookmyshow.dtos.RegisterUserResponseDto;
import org.example.bookmyshow.model.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request){
        User user = userService.registerUser(request.getName(), request.getEmail(), request.getPassword());
        return new RegisterUserResponseDto(user.getId());
    }

    @GetMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User getUser(@PathVariable("userId") Long id){
        return userService.getUserById(id);
    }
}
