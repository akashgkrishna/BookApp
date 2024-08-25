package celebi.getSimilarMovie;

import celebi.config.Config;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetSimilarMoviesTest {
    int movieId = 2050;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Config.getBaseUrl();
    }

    @Test
    public void validateGetAllMovieStatusCode() {

        RestAssured.given()
                .when()
                .get(Config.getEndpoint("similarMovie") + "/" + movieId)
                .then()
                .statusCode(200)
                .log().all();
    }
}
