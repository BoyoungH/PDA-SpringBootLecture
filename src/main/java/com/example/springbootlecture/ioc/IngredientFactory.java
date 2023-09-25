package com.example.springbootlecture.ioc;

public class IngredientFactory {
    public static Ingredient getIngredient(String menu) {
        return switch (menu) {
            case "치킨" -> new Chicken("국내산 닭");
            case "스테이크" -> new Pork("국내산 돼지");
            default -> throw new RuntimeException("처리할 수 있는 메뉴가 없습니다.");
        };
    }
}