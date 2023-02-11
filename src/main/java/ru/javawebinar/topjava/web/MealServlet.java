package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    {
        MealsUtil.fillMap();
    }

    private static final String LIST_MEAL = "/meals.jsp";
    private static final String CREATE_UPDATE = "/create.jsp";
    private static final String DELETE = "/delete";

    MealDAO dao = new MealDAO();
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        log.debug("redirect to meals");
        String forward = "";
        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("listMeals", dao.readAll());
            forward = LIST_MEAL;
            getServletContext().getRequestDispatcher(forward).forward(req,resp);
        } else {
            if (action.equalsIgnoreCase("delete")) {
                dao.delete(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("listMeals", dao.readAll());
                resp.sendRedirect("meals");
            } else if (action.equalsIgnoreCase("update")) {
                forward = CREATE_UPDATE;
                Meal meal = dao.read(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("meal", meal);
                req.getRequestDispatcher(forward).forward(req, resp);
            } else if (action.equalsIgnoreCase("listMeals")) {
                forward = LIST_MEAL;
                req.setAttribute("listMeals", dao.readAll());
                req.getRequestDispatcher(forward).forward(req, resp);
            } else {
                forward = CREATE_UPDATE;
                req.getRequestDispatcher(forward).forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        Meal meal = new Meal();
        meal.setDateTime(TimeUtil.formatLocalDateTime(req.getParameter("datetime")));
        meal.setCalories(Integer.parseInt(req.getParameter("calories")));
        meal.setDescription(req.getParameter("description"));

        if (id == null || id.isEmpty()) {
            dao.create(meal);
        } else {
            meal.setId(Integer.parseInt(id));
            dao.update(meal);
        }
        req.setAttribute("listMeals", dao.readAll());
        req.getRequestDispatcher(LIST_MEAL).forward(req, resp);
    }
}