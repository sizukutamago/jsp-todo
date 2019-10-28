package todo.controllers;

import todo.models.User;
import todo.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        User user = new User(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));
        userService.save(user);

        user = userService.getByEmail(user);

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/todo");
    }
}
