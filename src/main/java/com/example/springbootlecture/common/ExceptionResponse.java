package com.example.springbootlecture.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ExceptionResponse {


    //mapping용 instance 객체

    private final String message;
    private final int code;

}
