package com.example.springbootlecture.ioc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef {
    public final IngredientFactory ingredientFactory;
    public String cook(String menu) {
        // 재료 준비
        // Chicken chicken = new Chicken("국내산 닭");

        Ingredient ingredient = IngredientFactory.getIngredient(menu);

        // 뚝딱뚝딱

        // 요리 결과를 반환
        return ingredient.getName() + " " + menu;
    }
}
