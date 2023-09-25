package com.example.springbootlecture.ioc;

import com.example.springbootlecture.config.MyConfig;
import com.example.springbootlecture.config.MyConfigProto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PrintBeans {

    private final ApplicationContext applicationContext;
//    private final MyConfig myConfig;
//    private final MyConfigProto myConfigProto;

    @Bean
    public void printBeansMethod() {
        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).toList();

        for(String beanName: beans) {
            System.out.println(beanName);

         }
    }
}
