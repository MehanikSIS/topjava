package ru.javawebinar.topjava.web.meal;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;


@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final MealService service;
    private final int userId = SecurityUtil.authUserId();

    public MealRestController(MealService service) {
        this.service = service;
    }


    public Meal get(int id) {
        log.info("get {}", id);
        return service.get(userId, id);
    }

    public List<Meal> getAll() {
        log.info("getALL, {}", userId);
        return service.getALL(userId);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(userId, id);
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        return service.create(userId, meal);
    }

    public void update(Meal meal) {
        log.info("update {}", meal);
        service.update(userId, meal);
    }
}