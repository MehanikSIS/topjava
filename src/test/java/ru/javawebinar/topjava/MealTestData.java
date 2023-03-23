package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MealTestData {
    public static final int USER_ID = 100000;
    public static final int MEAL_ID = 1;
    public static final Meal meal = new Meal(MEAL_ID, LocalDateTime.of(2023, 3, 2, 9, 54, 0), "Завтрак", 900);

    public static final List<Meal> MEALS = Arrays.asList(
            new Meal(MEAL_ID + 2, LocalDateTime.of(2023, 3, 5, 18, 12, 0), "Ужин", 400),
            new Meal(MEAL_ID + 1, LocalDateTime.of(2023, 3, 4, 12, 43, 0), "Обед", 700),
            new Meal(MEAL_ID, LocalDateTime.of(2023, 3, 2, 9, 54, 0), "Завтрак", 900));


    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(List<Meal> actual, List<Meal> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static Meal getUpdated() {
        Meal newMeal = meal;
        newMeal.setDescription("Ужин");
        newMeal.setDateTime(LocalDateTime.of(2023, 03, 22, 18, 30, 0));
        newMeal.setCalories(1200);
        return newMeal;
    }

    public static Meal getNew() {
        return new Meal(LocalDateTime.of(2023, 1, 12, 13, 40, 0), "Полдник", 500);
    }
}
