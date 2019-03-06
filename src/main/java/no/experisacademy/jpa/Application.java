package no.experisacademy.jpa;

import no.experisacademy.jpa.jpa.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class Application {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

    public static void main(String[] args) {
        /*addUser("street_gangtzah93", "street_gangztah93@hotmail.com", "thisIsAmerica");
        addUser("persian_kittyGirlxx", "persiaforevah98@gmail.com", "apexLover123");
        addUser("JujuSmoker", "amster_lover@hotmail.com", "largeBong");
        addUser("Tequila_God", "tequila_shot@hotmail.com", "vodkaTequilaRumYes");
        addUser("Masterbaiter69", "master_of_baits@gmail.com", "69xxx69");*/

        for(user u : getUsers()){
            System.out.printf("|%3s|%28s|%30s|%25s|\n", u.getId(), u.getUser_name(), u.getEmail(), u.getPassword());
        }

        SpringApplication.run(Application.class, args);

    }

    private static List<user> getUsers(){
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

    private static void addUser(String user_name, String email, String password){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            user newUser = new user();

            newUser.setUser_name(user_name);
            newUser.setEmail(email);
            newUser.setPassword(password);

            manager.persist(newUser);

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
    }

}
