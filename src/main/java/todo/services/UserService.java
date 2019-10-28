package todo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import todo.dao.UserDAO;
import todo.models.User;

import javax.servlet.http.HttpSession;

public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User getByEmail(User user) {
        return userDAO.getByEmail(user);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public boolean isExistUser(User user) {
        User searchUser = getByEmail(user);

        return searchUser != null && bCryptPasswordEncoder.matches(user.getPassword(), searchUser.encryptPassword());
    }
}
