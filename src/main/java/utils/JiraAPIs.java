package utils;

import api.URLs;


public class JiraAPIs{



    public RequestSender createIssue(String body) {
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).post(URLs.ISSUE.getUri());
        return requestSender;
    }

    public RequestSender deleteIssue(String issueId){
        RequestSender requestSender = new RequestSender();
        requestSender.createEmptyRequest().delete(URLs.ISSUE.getUri(issueId));
        return requestSender;
    }

    public RequestSender editIssue(String body,String issueId){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).put(URLs.ISSUE.getUri(issueId));
        return requestSender;
    }

    public RequestSender commentIssue(String body, String issueId){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).post(URLs.ISSUE.getUri(issueId)+"/comment");
        return requestSender;
    }

    public RequestSender createFilter(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).post(URLs.FILTER.getUri());
        return requestSender;
    }

    public RequestSender deleteFilter(String filterId){
        RequestSender requestSender = new RequestSender();
        requestSender.delete(URLs.FILTER.getUri(filterId));
        return requestSender;
    }
    public RequestSender chengeMyPassword(String password){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(password).put(URLs.PASSWORD.getUri());
        return requestSender;
    }



}
