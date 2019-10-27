package todo.controllers;

import todo.models.Todo;
import todo.models.TodoList;
import todo.services.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class TaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoService todoService = new TodoService();
        TodoList todoList = todoService.getAll();
        req.setAttribute("todoList", todoList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Todo todo = new Todo(req.getParameter("todo"));
        TodoService todoService = new TodoService();
        todoService.save(todo);

        resp.sendRedirect("/");
    }
}
