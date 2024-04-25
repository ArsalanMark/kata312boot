package spring_boot.kata312_2.service;

import spring_boot.kata312_2.model.User;
import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void delete(int id);
    User getUser(int id);
    List<User> userList();
}
