
import common.GenerateRestSecurityToken;
import common.JsonFromObj;
import common.Retry;
import io.restassured.RestAssured;
import neocore.JsonTest;
import org.testng.annotations.Test;

public class GameRunTest extends BaseTest{
    GenerateRestSecurityToken generateRestSecurityToken = new GenerateRestSecurityToken();

    @Test(retryAnalyzer = Retry.class)
    public void emailVerificationTest() {
        RestAssured.given(getRequestSpecification(requestSpecification))
                .get("/api/emails_verification")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(retryAnalyzer = Retry.class)
    public void emailVerificationTest2() {
        String [] ere = {"ewr", "werew"};
        JsonTest jsonTest = new JsonTest(ere, "234234234324");
        String message = new JsonFromObj().jsonFromObj(jsonTest);

        RestAssured.given(postRequestSpecification(requestSpecification, jsonTest))
                .body(message)
                .post("/api/gifts/tags/zlo/batch-distribute")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
