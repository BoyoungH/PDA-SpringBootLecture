package com.example.springbootlecture.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {

    public OpenAPI swagger(){
        Info info = new Info();
        info.title("spring boot lecture api")
                .version("1.0.0")
                .description("안뇽");

        return new OpenAPI().info(info);
    }

}
