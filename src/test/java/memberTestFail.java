import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class memberTestFail {
    @Before() public void
    setUp() {
        RestAssured.port = 3000;
    }

    @Test() public void
    memberTwoMissingNameField() {
        when().get("/members/{id}", 2).
                then().
                statusCode(200).
                body("id", equalTo(2)).
                body("'Name 1'", not(equalTo("")));
    }
}
