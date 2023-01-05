package by.fin.project.repository;

import by.fin.project.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public Optional<User> findByUserName(String userName);
    public Boolean existsByUsername(String userName);
    public User saveUser(User user);
    public User updateUserPassword(User user);
    public User updateUserInfo(User user);

}
