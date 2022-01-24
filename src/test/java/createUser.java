import UserClient.users;
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
                " \"email\": \"tenali.rama13@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";

        //Act
        new users().createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }



    @Test
    public void createFemaleUser() {

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"Female\", \n" +
                " \"email\": \"soniak3@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        //Act
        new users().createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }


}
