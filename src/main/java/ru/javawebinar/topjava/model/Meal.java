package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.dao.MealDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {


    private Integer id;
    private LocalDateTime dateTime;

    private String description;

    private int calories;

    public Meal() {
        this.id = MealDAO.id.getAndIncrement();
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.id = MealDAO.id.getAndIncrement();
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public Integer getId() {
        return id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
