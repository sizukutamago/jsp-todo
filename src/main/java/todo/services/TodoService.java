package todo.services;

import todo.dao.TodoDAO;
import todo.models.TodoList;

public class TodoService {
    private TodoDAO todoDAO;

    public TodoService() {
        todoDAO = new TodoDAO();
    }

    public TodoList getAll() {
        return todoDAO.findAll();
    }
}
