package good_Example;


import com.jayway.restassured.http.ContentType;
import fixture.JiraJSON;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.JiraAPIs;
import utils.RequestSender;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class jira_Test_Good_ex {

    utils.RequestSender requestSender = new utils.RequestSender();
    String filterId = null;
    static String issueId = null;
    @BeforeTest(groups ={"Issue","Filter","MyAcc"} )
    public void login() {requestSender.authenticate();}

    @Test(groups = {"Issue"})
    public void createIssue(){
        JiraJSON jiraJSON = new JiraJSON();
        String issue = jiraJSON.generateJSONSampleIssue();
        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.createIssue(issue);
           issueId =  requestSender.extractResponseByPath("id");

        assertEquals(RequestSender.response.getStatusCode(), 201);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));
    }

    @Test(groups = {"Issue"})
    public void commentIssue(){
        JiraJSON jiraJSON = new JiraJSON();
        String comment = jiraJSON.genereteJSONForComment();
        System.out.println(comment);
        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.commentIssue(comment,issueId);
        System.out.println(RequestSender.response.asString());
        assertEquals(RequestSender.response.getStatusCode(), 201);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));
    }

    @Test(groups = {"Issue"})
    public void editIssueType(){
        JiraJSON jiraJSON = new JiraJSON();
        String type = jiraJSON.genereteJSONForEditIssueType();

        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.editIssue(type,issueId);

        assertEquals(requestSender.response.getStatusCode(), 204);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));

    }

    @Test(groups = {"Issue"})
    public void editIssueSumury() {
        JiraJSON jiraJSON = new JiraJSON();
        String summary = jiraJSON.genereteJSONForEditIssueSummary();

        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.editIssue(summary,issueId);

        assertEquals(RequestSender.response.getStatusCode(), 204);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));
    }

    @Test(groups = {"Issue"},dependsOnMethods = {"createIssue","editIssueType","commentIssue","editIssueSumury"},alwaysRun = true)
    public void deleteIssue(){
        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.deleteIssue(issueId);

        assertEquals(RequestSender.response.getStatusCode(), 204);
    }

    @Test(groups = {"Filter"})
    public void createFilter(){
        JiraJSON jiraJSON = new JiraJSON();
        String filter = jiraJSON.genereteJSONForFILTER();

        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.createFilter(filter);
        filterId = RequestSender.extractResponseByPath("id");
        System.out.println(RequestSender.response.asString());
        assertEquals(RequestSender.response.getStatusCode(), 200);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));
    }

    @Test(groups = {"Filter"})
    public void deleteFilter(){
        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.deleteFilter(filterId);

        assertEquals(RequestSender.response.getStatusCode(), 204);
        assertTrue(RequestSender.response.contentType().contains(ContentType.JSON.toString()));
    }
    @Test(groups = {"MyAcc"})
    public void chengePassword(){
        JiraJSON jiraJSON = new JiraJSON();
        String password = jiraJSON.genereteJSONForPassword();

        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.chengeMyPassword(password);
        assertEquals(requestSender.response.getStatusCode(), 204);
        assertTrue(requestSender.response.contentType().contains(ContentType.JSON.toString()));
    }
    @Test(groups ={"MyAcc"},dependsOnMethods = {"chengePassword"})
    public void chengePassBack(){
        JiraJSON jiraJSON = new JiraJSON();
        String cbpass = jiraJSON.genereteJSONForBackPassword();

        JiraAPIs jiraAPIs = new JiraAPIs();
        jiraAPIs.chengeMyPassword(cbpass);

        assertEquals(requestSender.response.getStatusCode(), 204);
        assertTrue(requestSender.response.contentType().contains(ContentType.JSON.toString()));
    }

  //  @Test

    //public void JSONTEST(){
   //    JiraJSON jiraJSON = new JiraJSON();
      //  System.out.println(jiraJSON.genereteJSONForPassword());
   // }

}
