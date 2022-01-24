import UserClient.users;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsers {

    private users User;

    @BeforeClass
    public void beforeClass()
    {
        User = new users();
    }
    @Test
    public void getAllUser() {
        User.
                getAllUsers()
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .log().body();
    }


}
