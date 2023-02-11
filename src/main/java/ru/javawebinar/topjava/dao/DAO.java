package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.Collection;

public interface DAO {

    void create(Meal meal);

    Meal read(Integer id);

    Collection<MealTo> readAll();

    void update(Meal meal);

    void delete(Integer id);
}