package no.experisacademy.controller;

import no.experisacademy.Application;
import no.experisacademy.jpa.characterClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    @GetMapping("/class")
    public List<characterClass> getAllClasses(){
        return Application.getClasses();
    }
    @GetMapping("/class/{name}")
    public characterClass getClassByName(@PathVariable String  name){
        characterClass returnClass = null;
        for (characterClass characterClass : getAllClasses()) {
            if (characterClass.getClassType().equalsIgnoreCase(name)) {
                returnClass = characterClass;
            }
        }

        return  returnClass;
    }



}
