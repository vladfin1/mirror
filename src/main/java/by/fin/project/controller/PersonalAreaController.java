package by.fin.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/area")
public class PersonalAreaController {


    @GetMapping("/main")
    @PreAuthorize("hasRole('ADMIN')")
    public Object goGet() {

        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/ping")
    public ResponseEntity<HttpStatus> goHead() {
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

}
