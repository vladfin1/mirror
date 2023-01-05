package by.fin.project.service;

import by.fin.project.domain.UserData;
import by.fin.project.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @Autowired
    UserDataRepository repository;

    public UserData saveUserData(UserData data){
        return repository.save(data);
    }

}
