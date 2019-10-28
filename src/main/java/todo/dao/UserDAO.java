package todo.dao;

import io.github.cdimascio.dotenv.Dotenv;
import todo.models.User;

import java.sql.*;

public class UserDAO {

    private String databaseUrl;

    private String databaseUser;

    private String databasePassword;

    public UserDAO() {
        databaseUrl = "jdbc:mysql://localhost/jsp-todo";
        databaseUser = "root";
        databasePassword = "";

        Dotenv dotenv = Dotenv.configure().directory("/").ignoreIfMissing().load();
        if (dotenv.get("DB_URL") != null) {
            databaseUrl = dotenv.get("DB_URL");
            databaseUser = dotenv.get("DB_USER");
            databasePassword = dotenv.get("DB_PASSWORD");
        }
    }

    public User getByEmail(User searchUser) {
        Connection connection = null;
        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

            String sql = "select * from user where email = ? limit 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchUser.getEmail());
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                return null;
            }
            user =  new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"));
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

        return user;
    }

    public void save(User user) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

            String sql = "insert into user (email, password, name) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.encryptPassword());
            statement.setString(3, user.getName());
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
