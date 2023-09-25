package com.example.springbootlecture.domain.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ShinhanRequest {

    private String company;
    private String content;
}
