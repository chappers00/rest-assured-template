import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class memberTest {
    @Before() public void
    setUp() {
        RestAssured.port = 3000;
    }

    @Test() public void
    memberFiveHasAnId() {
        when().get("/members/{id}", 5).
                then().
                statusCode(200).
                body("id", equalTo(5)).
                body("'Address 1'", equalTo("115280, Moscow, Avtozavodskaya st., 14"));
    }

    @Test() public void
    member101HasCorrectCountry() {
        when().get("/members/{id}",101).
                then().
                statusCode(200).
                body("Country", equalTo("Pakistan"));
    }
}
