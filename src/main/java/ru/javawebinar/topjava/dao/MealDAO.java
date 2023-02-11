package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;


public class MealDAO implements DAO {

    private static final ConcurrentMap<Integer, Meal> dataBase = new ConcurrentHashMap<>();

    public static Integer getId() {
        return id.get();
    }

    public static final AtomicInteger id = new AtomicInteger(1);

    public ConcurrentMap<Integer, Meal> getDatabase() {
        return dataBase;
    }

    public void create(Meal meal) {
        dataBase.put(meal.getId(), meal);
    }

    public Meal read(Integer id) {
        return dataBase.get(id);
    }

    public void update(Meal meal) {
        dataBase.put(meal.getId(), meal);

    }

    public void delete(Integer id) {
        dataBase.remove(id);
    }

    @Override
    public List<MealTo> readAll() {
        return MealsUtil.getListMealsTo(dataBase.values());
    }
}
