package com.example.springbootlecture;

import com.example.springbootlecture.config.MyConfig;
import com.example.springbootlecture.config.MyConfigProto;
import com.example.springbootlecture.ioc.Chef;
import com.example.springbootlecture.ioc.IngredientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLectureApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootLectureApplication.class, args);

//		IngredientFactory ingredientFactory = new IngredientFactory();
//		Chef chef = new Chef(ingredientFactory);
//
//		String food = chef.cook("치킨");
//		System.out.println(food);

	}

}
