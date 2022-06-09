# My-First-APP

It's a simple and basic CRUD API Rest with Spring.
You can create, read, update and delete an user who have these attributes:
{
    nom,
    prenom,
    email,
    date_naiss("YYYY-MM-DD"),
    tel,
    mdp
}

### Command to run application: .\mvnw spring-boot:run, and it's running on http://localhost:8080

#### To add an user: http://localhost:8080/user/add
#### To get all user: http://localhost:8080/user/all
#### To get user by email: http://localhost:8080/user/email?email=adresse@gmail.com
#### To get user by id: http://localhost:8080/user/id?id=1 (integer)
#### To delete user by if: http://localhost:8080/user/delete?id=1 (integer)

## Dependencies: Spring Web, JPA, MySqlDriver  
