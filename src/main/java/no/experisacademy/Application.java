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
        /*addUser("street_gangtzah93", "street_gangztah93@hotmail.com", "thisIsAmerica");
        addUser("persian_kittyGirlxx", "persiaforevah98@gmail.com", "apexLover123");
        addUser("JujuSmoker", "amster_lover@hotmail.com", "largeBong");
        addUser("Tequila_God", "tequila_shot@hotmail.com", "vodkaTequilaRumYes");
        addUser("Masterbaiter69", "master_of_baits@gmail.com", "69xxx69");*/

        /*for(user u : getUsers()){
            System.out.printf("|%3s|%28s|%30s|%25s|\n", u.getId(), u.getUser_name(), u.getEmail(), u.getPassword());
        }*/

        //System.out.println(getUsers().get(1).getCharacters());

        //Insert.addClass("Warrior", "Charge", "Taunt", "Berserker Rage");
        //Insert.addCharacter(1, "Warlord_Mafia", 4, 1);
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
