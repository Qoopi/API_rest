package bad_example_my;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import fixture.JiraJSON;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.JiraAPIs;
import utils.RequestSender;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class test_JIRA {
    String sessionId ;
    String issueId;
    String filtrId;
    utils.RequestSender requestSender = new utils.RequestSender();
    JiraAPIs jiraAPIs = new JiraAPIs();
    JiraJSON jiraJSON = new JiraJSON();

    @BeforeTest
    public void login() {
        requestSender.authenticate();
    }
    @Test
    public void createIssue(){
        String issue = jiraJSON.generateJSONSampleIssue();

        jiraAPIs.createIssue(issue);

        assertEquals(RequestSender.response.getStatusCode(), 201);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));

    }

    @Test
    public void editIssue() {
        given().
                contentType("application/json").
                cookie("JSESSIONID=" + sessionId).
                body("{\"update\":{\"summary\":[{\"set\":\"Bug in business logic\"}]}}").
                when().
                put("/rest/api/2/issue/" + issueId).
                then().
                statusCode(204);

    }
    @Test
    public void create_Filtr(){
        given().
                contentType("application/json").
                cookie("JSESSIONID=" + sessionId).
                body("{\n" +
                        "    \"name\": \"All Open Bug\",\n" +
                        "    \"description\": \"Lists all open bugs\",\n" +
                        "    \"jql\": \"type = Bug and resolution is empty\",\n" +
                        "    \"favourite\": true\n" +
                        "}").
                when().
                put("/rest/api/2/filter").
                then().
                statusCode(204).
                extract().
                path("id");
        System.out.println("Filtr ID " + filtrId);

    }
    @Test
    public void delete_Filtr(){
        given().
                contentType("application/json").
                cookie("JSESSIONID=" + sessionId).
                when().
                delete("/rest/api/2/filter/" + filtrId ).
                then().
                statusCode(204);
    }
    @Test
    public void change_Password(){
        given().
                contentType("application/json").
                cookie("JSESSIONID=" + sessionId).
                body("{\n" +
                        "    \"password\": \"125478963\",\n" +
                        "    \"currentPassword\": \"Q125478963q\"\n" +
                        "}").
                when().
                put("/rest/api/2/myself/password").
                then().
                statusCode(204);

    }
    @Test
    public void password_ChangeBack(){
        given().
                contentType("application/json").
                cookie("JSESSIONID=" + sessionId).
                body("{\n" +
                        "    \"password\": \"Q125478963q\",\n" +
                        "    \"currentPassword\": \"125478963\"\n" +
                        "}").
                when().
                put("/rest/api/2/myself/password").
                then().
                statusCode(204);
        System.out.println(" ky ky");
    }
    @AfterTest
    public void deleteIssue(){
        given().
                contentType("application/json").
                cookie("JSESSIONID="+sessionId).
                when().
                delete("/rest/api/2/issue/" + issueId ).
                then().
                statusCode(204);
    }

}


