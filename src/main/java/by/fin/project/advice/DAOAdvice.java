package by.fin.project.advice;

import by.fin.project.exception.DAOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DAOAdvice {

    @ResponseBody
    @ExceptionHandler(DAOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String employeeNotFoundHandler(DAOException ex) {
        return ex.getMessage();
    }

}
