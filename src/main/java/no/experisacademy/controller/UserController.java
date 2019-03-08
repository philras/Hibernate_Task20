package no.experisacademy.controller;

import no.experisacademy.jpa.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static no.experisacademy.Application.getUsers;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<user> getAllUsers(){
        return getUsers();
    }

    @GetMapping("/users/{id}")
    public user getUserById(@PathVariable int id){
        user returnUser = null;
        for (user user : getUsers()) {
            if (user.getId()==(id)) {
                returnUser = user;
            }
        }

        return  returnUser;
    }
}
