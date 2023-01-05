package by.fin.project.config;

import by.fin.project.domain.ERole;
import by.fin.project.domain.Role;
import by.fin.project.domain.User;
import by.fin.project.exception.DAOException;
import by.fin.project.repository.LoginRepository;
import by.fin.project.repository.RoleRepository;
import by.fin.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Component
@Slf4j
public class InitData {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void catalog() {
        initUsers();
    }

    private void initUsers() {
        if(loginRepository.findAll().isEmpty()){
            try {
                Role admin = new Role(ERole.ROLE_ADMIN);
                roleRepository.save(admin);
                Set<Role> a = new HashSet<>();
                a.add(admin);
                loginRepository.save(new User("admin", passwordEncoder.encode("admin"), a));
            }catch (DAOException e) {
                log.debug(e.getMessage());
            }
        }
    }

}
