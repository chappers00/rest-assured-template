package com.chappers00;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestAPIExamples {

    @Test
    //Also see https://any-api.com/xkcd_com/xkcd_com/docs/_info_0_json/GET
    public void testXkcdinfo0() {
        when().get("http://xkcd.com/info.0.json").
                then().
                statusCode(200).
                body("$", hasKey("title"));
    }

    @Test 
    public void testXkcdGetComic() {
        when().get("http://xkcd.com/{comicId}/info.0.json", "386").
        then().
        statusCode(200).
        body("safe_title", equalTo("Duty Calls"));
    }

    @Test
    public void testJsonSchema() {
            when()
            .get("https://jsonplaceholder.typicode.com/comments?postId=1")
            .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("schema.jsd"));
    }
}
