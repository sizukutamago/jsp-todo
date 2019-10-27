package todo.dao;

//import io.github.cdimascio.dotenv.Dotenv;
import todo.models.Todo;
import todo.models.TodoList;

import java.sql.*;

public class TodoDAO {

    private String databaseUrl;

    private String databaseUser;

    private String databasePassword;

    public TodoDAO() {
        databaseUrl = "jdbc:mysql://localhost/jsp-todo";
        databaseUser = "root";
        databasePassword = "";
    }

    public TodoList findAll() {
//        Dotenv dotenv = Dotenv.load();
//        databaseUrl = dotenv.get("DB_URL");
//        databaseUser = dotenv.get("DB_USER");
//        databasePassword = dotenv.get("DB_PASSWORD");
        TodoList todoList = new TodoList();
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

            String sql = "select * from todo";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Todo todo = new Todo(result.getInt("id"), result.getString("task"));
                todoList.addTodo(todo);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return todoList;
    }

    public void save(Todo todo) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

            String sql = "insert into todo (task) values (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, todo.getTask());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
