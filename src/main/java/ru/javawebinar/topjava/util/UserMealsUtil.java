package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // calc total calories per day
        Map<LocalDate, Integer> totalUserMealsCaloriesByDate = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            int totalPerDay = totalUserMealsCaloriesByDate.getOrDefault(userMeal.getDateTime().toLocalDate(), 0);
            totalPerDay += userMeal.getCalories();
            totalUserMealsCaloriesByDate.put(userMeal.getDateTime().toLocalDate(), totalPerDay);
        }
        //
        List<UserMealWithExceed> userMealsWithExceedBetween2Time = new ArrayList<>();
        for (UserMeal userMeal : mealList) {
            if(userMeal.getDateTime().toLocalTime().compareTo(startTime) >= 0 && userMeal.getDateTime().toLocalTime().compareTo(endTime) <= 0) {
                userMealsWithExceedBetween2Time.add(new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(),
                        caloriesPerDay < totalUserMealsCaloriesByDate.get(userMeal.getDateTime().toLocalDate())));
            }
        }
        return userMealsWithExceedBetween2Time;
    }
}
