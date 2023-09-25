package com.example.springbootlecture.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Shinhan {

    private long id;
    private String company;
    private String content;
    private LocalDateTime createAt;
}
