package com.example.springbootlecture.domain.response;

import com.example.springbootlecture.domain.entity.Shinhan;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShinhanResponse {

    private final long id;
    private final String company;
    private final String content;

    public static ShinhanResponse of (Shinhan company){
        return new ShinhanResponse(company.getId(),company.getCompany(), company.getContent());
    }

}
