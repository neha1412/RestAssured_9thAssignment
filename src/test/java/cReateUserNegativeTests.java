import UserClient.users;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class cReateUserNegativeTests {

    @Test
    public void createUserForNegativeTests() {

        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"Female\", \n" +
                " \"email\": \"soniak2gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        new users().createUser(body)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}