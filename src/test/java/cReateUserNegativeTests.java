import UserClient.Create.CreateUserRequestBody;
import UserClient.users;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class cReateUserNegativeTests {

    private users User;

    @BeforeClass
    public void beforeClass(){
        User= new users();
    }

    @Test
    public void createUserForNegativeTests() {

        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"Female\", \n" +
                " \"email\": \"soniak3gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Rama").gender("male")
                .email("soniak3gmail.com").status("active").build();
        User.createUser(requestBody)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}