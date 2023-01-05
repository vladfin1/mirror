package by.fin.project.controller;

import by.fin.project.config.JwtUtils;
import by.fin.project.domain.User;
import by.fin.project.domain.UserData;
import by.fin.project.dto.LoginDTO;
import by.fin.project.dto.RegistrationRequestDTO;
import by.fin.project.exception.DAOException;
import by.fin.project.mapper.RequestMapper;
import by.fin.project.repository.RoleRepository;
import by.fin.project.repository.UserRepository;
import by.fin.project.service.UserDataService;
import by.fin.project.service.UserDetailsImpl;
import by.fin.project.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    private RequestMapper mapper = Mappers.getMapper(RequestMapper.class);
    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> login(@RequestBody RegistrationRequestDTO user){
            User newUser = mapper.registrationRequestDTOtoUser(user);
            userService.saveUser(newUser);
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @GetMapping("/403")
    public String goGet() {
        return "Denied";
    }

}
