package todo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TodoList implements Serializable {

    private List<Todo> todoList = new ArrayList<>();

    public TodoList() {}

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public List<Todo> getTodoList() {
        return todoList;
    }
}
