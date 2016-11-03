package utils;

import api.URLs;


public class JiraAPIs{



    public RequestSender createIssue(String body) {
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).post(URLs.ISSUE.getUri());
        return requestSender;
    }

    public RequestSender deleteIssue(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).delete(URLs.ISSUE.getUri());
        return requestSender;
    }

    public RequestSender editIssue(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).put(URLs.ISSUE.getUri("QAAUT-38"));
        return requestSender;
    }

    public RequestSender commentIssue(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).put(URLs.ISSUE.getUri("QAAUT-38/comment"));
        return requestSender;
    }

    public RequestSender createFilter(String body){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(body).post(URLs.FILTER.getUri());
        return requestSender;
    }

    public RequestSender deleteFilter(String id){
        RequestSender requestSender = new RequestSender();
        requestSender.delete(URLs.FILTER.getUri());
        return requestSender;
    }
    public RequestSender chengeMyPassword(String password){
        RequestSender requestSender = new RequestSender();
        requestSender.createRequest(password).put(URLs.PASSWORD.getUri());
        return requestSender;
    }



}
