package todo.services;

import todo.dao.TodoDAO;
import todo.models.Todo;
import todo.models.TodoList;

public class TodoService {
    private TodoDAO todoDAO;

    public TodoService() {
        todoDAO = new TodoDAO();
    }

    public TodoList getAll() {
        return todoDAO.findAll();
    }

    public void save(Todo todo) {
        todoDAO.save(todo);
    }
}
