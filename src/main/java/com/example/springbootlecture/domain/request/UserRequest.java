package com.example.springbootlecture.domain.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {
    private String username;
    private String password;
    private String role;

}
