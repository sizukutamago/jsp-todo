package todo.models;

import java.io.Serializable;

public class Todo implements Serializable {
    private int id;

    private String task;

    public Todo() {}

    public Todo(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }
}
