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

        String name= "Tenali Rama";
        String gender= "male";
        String status= "active";
        String email ="soniak3gmail.com";

        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"Female\", \n" +
                " \"email\": \"soniak3gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);
        User.createUser(requestBody)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}