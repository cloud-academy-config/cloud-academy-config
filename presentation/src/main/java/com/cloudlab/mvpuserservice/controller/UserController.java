package com.cloudlab.mvpuserservice.controller;

import com.cloudlab.mvpuserservice.data.dto.UserDto;
import com.cloudlab.mvpuserservice.data.entity.UserEntity;
import com.cloudlab.mvpuserservice.service.UserService;
import com.cloudlab.mvpuserservice.data.vo.RequestUser;
import com.cloudlab.mvpuserservice.data.vo.ResponseUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Lazy
@RestController
@Slf4j
@RequestMapping("/user-service")
public class UserController {

    private UserService userService;

    private String greetingMessage;

    public UserController(UserService userService, String greetingMessage) {
        this.userService = userService;
        this.greetingMessage = greetingMessage;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userEntities = userService.getUserByAll();
        List<ResponseUser> result = new ArrayList<>();
        userEntities.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseUser.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/greeting")
    public ResponseEntity<String> getGreeting() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return ResponseEntity.status(HttpStatus.OK).body(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(greetingMessage));
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<ResponseUser> getUsers(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUserByUserId(userId);
        ResponseUser result = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
