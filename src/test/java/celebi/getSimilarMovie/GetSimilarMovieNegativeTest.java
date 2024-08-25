package celebi.getSimilarMovie;

import celebi.config.Config;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetSimilarMovieNegativeTest {
    String movieId = "hello";


    @BeforeClass
    public void setup(){
        RestAssured.baseURI = Config.getBaseUrl();
    }

    @Test
    public void validateSimilarMovieStatusCode(){
        RestAssured.given()
                .when()
                .get(Config.getEndpoint("similarMovie") + "/" + movieId)
                .then()
                .statusCode(400)
                .body("title", equalTo("One or more validation errors occurred."))
                .log().all();
    }
}

