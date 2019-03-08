package no.experisacademy.controller;

import no.experisacademy.Application;
import no.experisacademy.jpa.character;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @GetMapping("/characters")
    public List<character> getAllCharacters(){
        return Application.getCharacters();
    }

    @GetMapping("/characters/{id}")
    public character getCharacterById(@PathVariable int id){
        character returnCharacter = null;
        for (character character : Application.getCharacters()) {
            if (character.getId()==(id)) {
                returnCharacter = character;
            }
        }

        return  returnCharacter;
    }

}
