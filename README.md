# Word Search Service

Java REST API using the **Levenshtein distance** algorithm to return the frequency and the list of similarities of a provided word inside a given text.

## Key features

* Search for the exact match of a provided word in a notebook entry and return it's  frequency.
* Given a word , extract the list of similar words inside a notebook entry based on Levenshtein distance algorithm.


## Building

### Development environment:

* IDE : Eclipse Version: 2021-09 (4.21.0)
* Framework: Spring Boot 

### Prerequisites:

 1. Java jdk 1.8 .
 2. <a href="https://maven.apache.org/" target="_blank">Apache Maven 4.0.0</a>
 3. Internet access
 4. Git client

### Build

```sh
git clone https://github.com/edgardsaad/word-search-service.git
cd word-search-service
mvn install
```
After the mvn install :
- Run as "Spring Boot App" for development purposes
- Find the built jar under "/word-search-service/target" to be used as production package

### Additional POC :

An Angular project was developed as a POC for consuming this API. 
The code of this POC is shared in the below repository :

```sh
git clone https://github.com/edgardsaad/word-search-service-FE.git
cd word-search-service-FE
ng serve
```

### Test Scenarios

Two test scenarios are included in this project under "/word-search-service/src/test/java"

* Scenario 1: 
  * Parameters :
    * word :Word
    * text :Word Words Wor word
  * Expected result : 
    * Frequency :1
    * Similarities :Words,Wor,word

* Scenario 2:
   * Parameters :
    * word :Word
    * text :Word Word Word word
  * Expected result : 
    * Frequency :3
    * Similarities :word


## Notes

### Summary of work done:

* Time spent : 6.5 hrs 
* REST API with Get method was created to take two parameters 
word : represents the word we are searching for
text : represents the notebook entry we are searching in
  
* Testing class with two test scenarios

* Angular project as a POC 

### Additional Work to be done

* Update the API to accept the acceptable ditance as parameter
* Additional test scenarios covering all functionalities
* Further documentation of the code 
* User Option to use other text distance algorithms in addition to the Levenshtein algorithm
* Containerize the solution (using Docker)
