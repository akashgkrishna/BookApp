package celebi.getMovie;

import celebi.config.Config;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetAllMovieTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Config.getBaseUrl();
    }

    @Test
    public void validateGetAllMovieStatusCode() {
        RestAssured.given()
                .when()
                .get(Config.getEndpoint("movie"))
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validateMovieResponseStructure() {
        RestAssured.given()
                .when()
                .get(Config.getEndpoint("movie"))
                .then()
                .statusCode(200)
                .assertThat()
                .body("movieId", everyItem(notNullValue()))
                .body("title", everyItem(notNullValue()))
                .body("overview", everyItem(notNullValue()))
                .body("genre", everyItem(notNullValue()))
                .body("language", everyItem(notNullValue()))
                .body("duration", everyItem(notNullValue()))
                .body("rating", everyItem(notNullValue()))
                .body("posterPath", everyItem(notNullValue()));
    }

    @Test
    public void validateMovieCount() {
        RestAssured.given()
                .when()
                .get(Config.getEndpoint("movie"))
                .then()
                .statusCode(200)
                .body("size()", equalTo(20)); // Assuming 28 is the expected count
    }

    @Test
    public void validateMovieLanguage() {
        RestAssured.given()
                .when()
                .get(Config.getEndpoint("movie"))
                .then()
                .statusCode(200)
                .body("language", hasItem(equalTo("English")));
    }
}
