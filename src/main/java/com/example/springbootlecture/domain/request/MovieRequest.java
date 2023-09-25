package com.example.springbootlecture.domain.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MovieRequest {

    private  String name;
    private  Integer productionYear;

}
