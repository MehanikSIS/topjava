package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Modifying
    @Transactional
    @Query(name = Meal.DELETE)
    int delete(@Param("id") int id, @Param("userId") int user_id);

    @Transactional
    @Query(value = "select * from meal where id=:id and user_id=:user_id", nativeQuery = true)
    Meal findByIdAndId(@Param("id") int id, @Param("user_id") int user_id);

    @Transactional
    @Query(value = "select * from meal where user_id=:userId order by date_time desc", nativeQuery = true)
    List<Meal> getAllById(@Param("userId") int userId);

    @Transactional
    @Query(name = Meal.GET_BETWEEN)
    List<Meal> getAllBetweenHalfOpen(@Param("userId") int userId, @Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);



}
