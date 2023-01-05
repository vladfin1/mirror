package by.fin.project.repository;

import by.fin.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String name);
    Boolean existsByUserName(String name);
}
