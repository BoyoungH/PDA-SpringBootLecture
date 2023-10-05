package com.example.springbootlecture.controller;

import com.example.springbootlecture.domain.request.UserRequest;
import com.example.springbootlecture.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/user/join")
    public void join(
            @RequestBody UserRequest userRequest
    ){
        userService.join(userRequest);
    }

    @GetMapping("/home")
    public String home(){
        return "어서와^^ 로그인 성공했네";
    }
    @GetMapping("/admin")
    public String admin(){
        return "어서와^^ admin 로그인 성공했네";
    }
    @GetMapping("/manager")
    public String manager(){
        return "어서와^^ manager 로그인 성공했네";
    }
}
