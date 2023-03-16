import common.GenerateRestSecurityToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    protected RequestSpecification requestSpecification;
    protected String privateKey;
    protected String base_url;
    GenerateRestSecurityToken generateRestSecurityToken = new GenerateRestSecurityToken();

    @BeforeMethod
    public void setUp(ITestContext context) {
        this.base_url = context.getCurrentXmlTest().getParameter("baseUrl");
        String publicKey = context.getCurrentXmlTest().getParameter("publicKey");
        this.privateKey = context.getCurrentXmlTest().getParameter("privateKey");
        requestSpecification = new RequestSpecBuilder().
                setBaseUri(base_url)
                .addHeader("Rest-Public-Client",publicKey)
                .build();
    }

    public RequestSpecification getRequestSpecification(RequestSpecification requestSpecification) {
        return requestSpecification
                .headers("Rest-Security-Token", generateRestSecurityToken.restSecurityToken(privateKey));
    }

    public RequestSpecification postRequestSpecification(RequestSpecification requestSpecification, Object body) {
        String token = generateRestSecurityToken.postSecurityToken(privateKey, body);
        return requestSpecification.headers("Rest-Security-Token", token);
    }
}
