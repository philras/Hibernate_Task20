TABLE user
ID int PRIMARY KEY
userName TEXT
email TEXT
password TEXT

TABLE characters
ID int PRIMARY KEY
userId FOREIGN KEY references user(ID)
name TEXT
level int
FKclassID FOREIGN KEY referencec classes(ClassID)

TABLE classes
ClassID int PRIMARY KEY
ClassType TEXT
Ability1 TEXT
Ability2 TEXT
Ability3 TEXT

USER
GET /user       Show all usernames in database

GET /user/{id}      Show user by id
ex. /user/1

POST /user      Add a new user to database
Body JSON:
{
    "userName": null,
    "email": null,
    "password": null,
}

CHARACTER
GET /character       Show all characters in database

GET /character/{id}      Show character by id
ex. /character/1

POST /character      Add a new character to database
Body JSON:
{
    "userId": 0,
    "name": null,
    "level": 0
}

CLASS
GET /class       Show all classes in database

GET /class/{name}      Show class by name
ex. /class/hunter





