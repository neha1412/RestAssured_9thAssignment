import UserClient.Create.CreateUserRequestBody;
import UserClient.users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class createUser {


    private users User;
    @BeforeClass
    public void beforeClass(){
        User = new users();

    }

    @Test
    public void createMaleUser() {

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "  \"name\": \"Tenali Rama\", \n" +
                " \"gender\": \"male\", \n" +
                " \"email\": \"%s\",\n" +
                " \"status\": \"active\"\n" +
                "}", email);

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Rama").gender("male")
                .email(email).status("active").build();

        //Act
        User.createUser(requestBody)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }



    @Test
    public void createFemaleUser() {

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"Female\", \n" +
                " \"email\": \"%s\",\n" +
                " \"status\": \"active\"\n" +
                "}", email);


        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Sonia K").gender("Female")
                .email(email).status("active").build();
        //Act
        User.createUser(requestBody)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }


}
