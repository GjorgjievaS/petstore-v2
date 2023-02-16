# Pet Store Application

### How to run the application

- Download the zip 
- Unzip the file 
- Open Intellij
- File -> Open-> Navigate to the unzipped folder 
- Click on the pom.xml file -> Open as Project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run 'PetstoreApplication'

### Open Postman

## For Users 

If you want to add one or more users manually <br>

**POST  localhost:8080/api/users**

and in the **body** select **raw** and add data in the following format <br>
```json
{
    "firstName":"Annie",
    "lastName" : "Walker",
    "email" : "annie@test.com",
    "budget" : 120.0
}
```

If you want to add 1-10 users with api <br>

**POST localhost:8080/api/users/create-all/{numUsers}** <br>

ex. **POST localhost:8080/api/users/create-all/3**   <br>

and in the **body** select **none**


If you want to see the users added to the list  <br>

**GET localhost:8080/api/users**

## For Pets

If you want to add one or more pets manually <br>

**POST  localhost:8080/api/pets** <br>

and in the **body** select **raw** and add data in the following format <br>
```json
{
        "name": "Biscuit",
        "type": "CAT",
        "description": "Abyssinian",
        "dateOfBirth": "Jun 1, 2020",
        "rating": -1,
        "owner": null,
        "price": 2.0
}
```

If you want to add 1-20 pets with api <br>

**POST localhost:8080/api/pets/create-all/{numPets}** <br>

ex. **POST localhost:8080/api/pets/create-all/8**  <br>

and in the **body** select **none**

If you want to see the pets added to the list  <br>

**GET localhost:8080/api/pets**


## For Transactions

if you want to go all over the users and try to buy a pet of the store <br>

**POST localhost:8080/api/purchase/buy**

if you want to see all of the users that bought a pet <br>

**GET localhost:8080/api/purchase**

