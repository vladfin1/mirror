package by.fin.project.mapper;

import by.fin.project.domain.User;
import by.fin.project.dto.RegistrationRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RequestMapper {

    @Mapping(target = "userName", source = "dto.login")
    User registrationRequestDTOtoUser(RegistrationRequestDTO dto);

}
