package no.experisacademy.controller;

import no.experisacademy.jpa.character;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static no.experisacademy.Application.getCharacters;

@RestController
public class CharacterController {

    @GetMapping("/character")
    public List<character> getAllCharacters(){
        return getCharacters();
    }

    @GetMapping("/character/{id}")
    public character getCharacterById(@PathVariable int id){
        character returnCharacter = null;
        for (character character : getCharacters()) {
            if (character.getId()==(id)) {
                returnCharacter = character;
            }
        }

        return  returnCharacter;
    }

    @PostMapping("/character")
    public character addCharacter(@RequestBody character character){

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            manager.persist(character);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            manager.close();
        }

        return character;
    }


}
