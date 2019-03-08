package no.experisacademy.controller;

import no.experisacademy.jpa.user;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static no.experisacademy.Application.getUsers;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<user> getAllUsers(){
        return getUsers();
    }

    @GetMapping("/test")
    public List<user> getAlusers(){
        List<user> usersList = null;

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            usersList = manager.createQuery("SELECT userName from user s ").getResultList();

            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }

            e.printStackTrace();
        }finally {
            manager.close();
        }

        return usersList;
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

    @PostMapping("/user")
    public user addUser(@RequestBody user user){

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            manager.persist(user);

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

        return user;
    }
}
