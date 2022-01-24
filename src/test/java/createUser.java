import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUser {

    @Test
    public void createMaleUser() {

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Rama\", \n" +
                " \"gender\": \"male\", \n" +
                " \"email\": \"tenali.rama12@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";

        //Act
        createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7af240fb7b557b1314869bc519303f4e79eb90f287818ef0c9b01eef8e85f17a")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

    @Test
    public void createFemaleUser() {

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"Female\", \n" +
                " \"email\": \"soniak2@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        //Act
        createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }
}
