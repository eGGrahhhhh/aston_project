import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {

    private final static String URL = "https://postman-echo.com";

    @Test
    public void GetRequestTest() {

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .contentType(ContentType.JSON)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));

    }

    @Test
    public void PostRawTextTest() {

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .contentType(ContentType.JSON)
                .body("{\"test123\":\"value123\"}")
                .when()
                .post("/post")
                .then()
                .assertThat()
                .body("json.test123", equalTo("value123"));
    }

    @Test
    public void PostFormDataTest() {

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .assertThat()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void PutRequestTest(){

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .assertThat()
                .body("data",equalTo("This is expected to be sent back as part of response body."));
    }
    @Test
    public void DeleteRequestTest() {

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .assertThat()
                .body("data",equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void PatchRequestTest() {

        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecOK200());
        given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .assertThat()
                .body("data",equalTo("This is expected to be sent back as part of response body."));
    }
}
