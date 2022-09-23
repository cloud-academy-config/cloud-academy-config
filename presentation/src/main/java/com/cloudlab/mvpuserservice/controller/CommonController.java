package com.cloudlab.mvpuserservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@Slf4j
@RequestMapping("/user-service")
public class CommonController {
    private Environment env;

    @Autowired
    public CommonController(Environment env) {
        this.env = env;
    }

    @GetMapping(value = "/health-check")
    public String status() {
        return String.format("It's working in User service on Port %s",
                env.getProperty("local.server.port"));
    }

    @GetMapping(value = "/anonymous")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }

    @RolesAllowed("mvp-user")
    @GetMapping(value = "/user")
    public ResponseEntity<String> getUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello User");
    }

    @RolesAllowed("mvp-admin")
    @GetMapping(value = "/admin")
    public ResponseEntity<String> getAdmin(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello Admin");
    }

    @RolesAllowed({ "mvp-admin", "mvp-user" })
    @GetMapping(value = "/all-user")
    public ResponseEntity<String> getAllUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello All User");
    }
}
