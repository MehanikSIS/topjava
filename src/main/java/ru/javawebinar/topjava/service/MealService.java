package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;

@Service
public class MealService {

    private final MealRepository repository;


    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(int userId, Meal meal) {
        return repository.save(userId, meal);
    }

    public void delete(int userId, int id) {
        repository.delete(userId, id);
    }

    public List<Meal> getALL(int userId) {
        return repository.getAll(userId);
    }

    public Meal get(int userId, int id) {
        return repository.get(userId, id);
    }

    public void update(int userId, Meal meal) {
        ValidationUtil.checkNotFound(repository.save(userId, meal), meal + " do not belong" + userId);
    }

}