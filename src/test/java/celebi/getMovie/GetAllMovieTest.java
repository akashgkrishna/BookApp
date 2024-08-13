package celebi.getMovie;

import celebi.config.Config;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllMovieTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Config.getBaseUrl();
    }

    @Test
    public void getAllMovie() {
        RestAssured.given()
                .when()
                .get(Config.getEndpoint("movie"))
                .then()
                .statusCode(200)
                .log().all();
    }
}
