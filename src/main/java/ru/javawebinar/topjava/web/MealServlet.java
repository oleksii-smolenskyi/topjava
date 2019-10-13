package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final SimpleDateFormat parserDateTime = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
    private static final SimpleDateFormat formatterDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allMeals", MealsUtil.getFiltered(MealsUtil.getMeals(), LocalTime.MIN, LocalTime.MAX, MealsUtil.DEFAULT_CALORIES_PER_DAY));
        req.setAttribute("parserDateTime", parserDateTime);
        req.setAttribute("formatterDateTime", formatterDateTime);
        log.debug("Forward to meals.jsp");
        req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }
}
