package com.example.springbootlecture.ioc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter

public class Pork implements Ingredient{

    private final String name;
}
