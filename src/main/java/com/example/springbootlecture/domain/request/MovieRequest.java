package com.example.springbootlecture.domain.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MovieRequest {
    private final String name;
    private final int productionYear;
    private final Long directorId;
}