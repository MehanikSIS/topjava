package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
}
)
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {
    @Autowired
    MealService service;

    @Test
    public void get() {
        Meal meal = service.get(MEAL_ID, USER_ID);
        assertMatch(meal, MealTestData.meal);
    }

    @Test
    public void getSomeone() {
        assertThrows(NotFoundException.class, () -> service.get(MEAL_ID, USER_ID + 1));
    }

    @Test
    public void deleteSomeone() {
        service.delete(MEAL_ID, USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(MEAL_ID, USER_ID));
    }

    @Test
    public void delete() {
        assertThrows(NotFoundException.class, () -> service.delete(MEAL_ID, USER_ID + 1));
    }

    @Test
    public void getBetweenInclusive() {
    }

    @Test
    public void getAll() {
        List<Meal> actual = service.getAll(USER_ID);
        assertMatch(actual, MEALS);
    }

    @Test
    public void update() {
        Meal editMeal = getUpdated();
        service.update(editMeal, USER_ID);
        assertMatch(service.get(MEAL_ID, USER_ID), editMeal);
    }

    @Test
    public void create() {
        Meal created = service.create(getNew(), USER_ID);
        Integer createdId = created.getId();
        Meal newMeal = getNew();
        newMeal.setId(createdId);
        assertMatch(created, newMeal);
        assertMatch(service.get(createdId, USER_ID), created);
    }
}