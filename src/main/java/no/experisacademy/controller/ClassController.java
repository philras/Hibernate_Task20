package no.experisacademy.controller;

import no.experisacademy.Application;
import no.experisacademy.jpa.characterClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    @GetMapping("/classes")
    public List<characterClass> getAllClasses(){
        return Application.getClasses();
    }


}
