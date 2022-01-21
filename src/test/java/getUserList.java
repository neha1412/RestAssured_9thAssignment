import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUserList {
    @Test
    public void getAllUser(){
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log().body();
    }

}
