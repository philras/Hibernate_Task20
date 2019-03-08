package no.experisacademy;

import no.experisacademy.jpa.character;
import no.experisacademy.jpa.characterClass;
import no.experisacademy.jpa.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

    public static void addUser(String user_name, String email, String password){
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

    public static void addClass(String className, String ability1, String ability2, String ability3){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            characterClass cClass = new characterClass();

            cClass.setClassType(className);
            cClass.setAbility1(ability1);
            cClass.setAbility2(ability2);
            cClass.setAbility3(ability3);

            manager.persist(cClass);

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

    public static void addCharacter(int userId, String name, int level, int classId){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            character c = new character();

            c.setUserId(userId);
            c.setName(name);
            c.setLevel(level);
            c.setFKclassID(classId);

            manager.persist(c);

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
