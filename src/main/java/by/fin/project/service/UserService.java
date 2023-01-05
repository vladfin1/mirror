package by.fin.project.service;

import by.fin.project.domain.ERole;
import by.fin.project.domain.Role;
import by.fin.project.domain.User;
import by.fin.project.exception.DAOException;
import by.fin.project.repository.LoginRepository;
import by.fin.project.repository.UserRepository;
import by.fin.project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserService implements UserRepository {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return loginRepository.findUserByUserName(userName);
    }

    @Override
    public Boolean existsByUsername(String userName) {
        return loginRepository.existsByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        if (existsByUsername(user.getUserName())){
            throw new DAOException("User exists");
        }
        Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        return loginRepository.save(user);
    }

    @Override
    public User updateUserInfo(User user) {
        return null;
    }

    @Override
    public User updateUserPassword(User user) {
        if (!existsByUsername(user.getUserName())){
            throw new DAOException("User doesnt exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return loginRepository.save(user);
    }

}
