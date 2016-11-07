package fixture;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



    public class JiraJSON {

        private static String name = "Geloksmmm";
        private static String password = "Q125478963q";

        public String generateJSONForLogin() {
            JSONObject credentials = new JSONObject();
            credentials.put("username", name);
            credentials.put("password", password);
            return credentials.toJSONString();
        }

        public String generateJSONSampleIssue() {
            JSONObject issue = new JSONObject();
            JSONObject fields = new JSONObject();
            JSONObject project = new JSONObject();
            JSONObject issuetype = new JSONObject();
            JSONObject assignee = new JSONObject();
            JSONObject reporter = new JSONObject();
            JSONObject priority = new JSONObject();

            project.put("id", "10315");
            issuetype.put("id", "10004");
            assignee.put("name", "Geloksmmm");
            reporter.put("name", "Geloksmmm");
            //priority.put("priority")
            String summary = "Shit HAPPEN";
            fields.put("project", project);
            fields.put("summary", summary);
            fields.put("issuetype", issuetype);
            fields.put("assignee", assignee);
            fields.put("reporter", reporter);
           // fields.put("priority", priority);
            issue.put("fields", fields);
            return issue.toJSONString();
        }

        public String genereteJSONForEditIssueSummary(){


            JSONObject update = new JSONObject();
            JSONObject summary = new JSONObject();
            JSONArray ar = new JSONArray();
            JSONObject set = new JSONObject();
            ar.add(set);
            set.put("set","Bug in business logic");
            summary.put("summary",ar);
            update.put("update",summary );


            return update.toJSONString();
        }

        public String genereteJSONForEditIssueType(){
            JSONObject issuetype = new JSONObject();
            JSONObject fields = new JSONObject();
            JSONObject id = new JSONObject();
            id.put("id","10004");
            issuetype.put("issuetype",id);
            fields.put("fields",issuetype);
            return fields.toString();
        }

        public String genereteJSONForComment(){

            JSONObject comment = new JSONObject();
            comment.put("body","SHit happens");
            return comment.toString();
        }

        public String genereteJSONForFILTER(){

                JSONObject filter = new JSONObject();
                filter.put("name", "Bugs");
                filter.put("description", "Lists all open bugs");
                filter.put("jql", "type = bug");
               // filter.put("favorite", new Boolean(true));
            return filter.toJSONString();
        }
        public  String genereteJSONForPassword(){
            JSONObject cpassword = new JSONObject();
            cpassword.put("password","125478963");
            cpassword.put("currentPassword","Q125478963q");
            return cpassword.toJSONString();
        }
        public  String genereteJSONForBackPassword(){
            JSONObject cbpassword = new JSONObject();
            cbpassword.put("password","Q125478963q");
            cbpassword.put("currentPassword","125478963");
            return cbpassword.toJSONString();
        }
    }


