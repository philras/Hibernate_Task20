package no.experisacademy;

import no.experisacademy.jpa.character;
import no.experisacademy.jpa.characterClass;
import no.experisacademy.jpa.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
@ComponentScan("no.experisacademy")
public class Application {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    public static List<user> getUsers(){
        List<user> usersList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            usersList = manager.createQuery("SELECT s from user s ", user.class).getResultList();

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

    public static List<character> getCharacters(){
        List<character> characterList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            characterList = manager.createQuery("SELECT s from character s ", character.class).getResultList();

            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }

            e.printStackTrace();
        }finally {
            manager.close();
        }

        return characterList;
    }

    public static List<characterClass> getClasses(){
        List<characterClass> classList = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            classList = manager.createQuery("SELECT s from characterClass s ", characterClass.class).getResultList();

            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }

            e.printStackTrace();
        }finally {
            manager.close();
        }

        return classList;
    }





}
