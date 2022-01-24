import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsers {
    @Test
    public void getAllUser() {
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .log().body();
    }
}
