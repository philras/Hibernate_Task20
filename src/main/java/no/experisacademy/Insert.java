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

    public static void fillDB(){

        addUser("street_gangtzah93", "street_gangztah93@hotmail.com", "thisIsAmerica" );
        addUser("persian_kittyGirlxx", "persiaforevah98@gmail.com", "apexLover123" );
        addUser("JujuSmoker", "amster_lover@hotmail.com", "largeBong" );
        addUser("Tequila_God", "tequila_shot@hotmail.com", "vodkaTequilaRumYes" );
        addUser("Masterbaiter69", "master_of_baits@gmail.com", "69xxx69" );

        addClass("Warrior", "Charge", "Taunt", "Berserker Rage");
        addClass("Mage", "Blink", "Frost Nova", "Time Warp");
        addClass("Hunter", "Call Pet", "Tracking", "Eagle Eye");
        addClass("DrunkHead", "Throw Up", "Burp", "Pass Out");

        addCharacter(1, "Warlord_Mafia", 4, 1);
        addCharacter(1, "MilfHunter", 6, 3);
        addCharacter(2, "CatWoman", 41, 2);
        addCharacter(2, "Hello_Kitty", 3, 3);
        addCharacter(2, "Pusur", 32, 1);
        addCharacter(3, "PurpleHaze", 101, 3);
        addCharacter(4, "Drunken_Master", 49, 4);
        addCharacter(4, "GT", 10, 2);
        addCharacter(5, "MiaK", 69, 2);
        addCharacter(5, "Canela", 26, 1);
        addCharacter(5, "Pamela", 32, 3);
    }

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
