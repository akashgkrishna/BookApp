## Movie API Test Automation

This project provides a Test Automation Framework for validating endpoints of a Movie API using RestAssured and TestNG.

### Project Structure

```
README.md
build.gradle.kts
config/
  movie/
    prod.properties
gradle/
  wrapper/
    gradle-wrapper.jar
    gradle-wrapper.properties
gradlew
gradlew.bat
src/
  main/
    java/
      celeb/
        config/
          Config.java
    resources/
  test/
    java/
      celeb/
        getMovie/
          GetAllMovieTest.java
        getSimilarMovies/
        getUser/
    resources/
      testng.xml

```

### Movie App Information

-   Website: [Movie App](https://movieapp-angular.azurewebsites.net/)
-   API Documentation: [Movie App APIs](https://movieapp-angular.azurewebsites.net/swagger/index.html)

### Prerequisites

-   Java 8 or above
-   Gradle 6.0 or above
-   TestNG 7.9.0
-   RestAssured 5.5.0
-   Allure TestNG 2.20.0

### Installation

1.  **Clone the Repository**



    ```
    git clone git@github.com:akashgkrishna/MovieApp.git
    ```


2.  **Install Java**

    -   **Windows:**


        ```
        scoop install openjdk
        ```
        
        
    -   **macOS:**

        
        ```
        brew install openjdk
        ```

3.  **Install Gradle**

    -   **Windows:**

        ```
        scoop install gradle
        ```


    -   **macOS:**
        
        ```
        brew install gradle
        ```

4.  **Install Allure**

    -   **Windows:**

        ```
        scoop install allure
        ```

    -   **macOS:**

        ```
        brew install allure
        ```


### Running the Tests

**Windows:**

Open PowerShell and execute

```
gradle test
```

**macOS/Linux:**

Open the terminal and execute:
```
./gradlew test
```
### Generating Allure Report

After running the tests, generate and view the Allure report using the following commands:

**Generate the report:**

```
allure generate
```

**View the report (in case it is already generated):**


```
allure serve
```

### Test Configuration

Tests are configured using the `testng.xml` file located in `src/test/resources/`. You can add or remove tests by modifying this file.

### Custom Configurations

The API base URL and endpoints are configured in the `prod.properties` file located in `config/movie/`. Modify this file to point to different environments or endpoints.