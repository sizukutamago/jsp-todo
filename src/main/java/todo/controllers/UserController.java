package todo.controllers;

import todo.models.User;
import todo.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = req.getSession();
        User user = new User(req.getParameter("email"), req.getParameter("password"));

        Boolean isExistUser = userService.isExistUser(user);

        if (isExistUser) {
            session.setAttribute("userErrorMessage", "ユーザが存在しません");
            resp.sendRedirect("/");
        } else {
            session.setAttribute("user", userService.getByEmail(user));
            resp.sendRedirect("/todo");
        }
    }
}
