package com.demo.shutterstockApi.dto;

public class DataDto {

    private String verdict_time;

    private String user_name;

    private String contributor;

    private String verdict;

    private String reason;

    private String ratings;

    private String title;

    private String keywords;

    //All args constructor
    public DataDto(String verdict_time, String user_name, String contributor, String verdict, String reason, String ratings, String title, String keywords) {
        this.verdict_time = verdict_time;
        this.user_name = user_name;
        this.contributor = contributor;
        this.verdict = verdict;
        this.reason = reason;
        this.ratings = ratings;
        this.title = title;
        this.keywords = keywords;
    }

    //no args constructor
    public DataDto() {
    }

    //Getters and Setters
    public String getVerdict_time() {
        return verdict_time;
    }

    public void setVerdict_time(String verdict_time) {
        this.verdict_time = verdict_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    //toString method
    @Override
    public String toString() {
        return "DataDto{" +
                "verdict_time='" + verdict_time + '\'' +
                ", user_name='" + user_name + '\'' +
                ", contributor='" + contributor + '\'' +
                ", verdict='" + verdict + '\'' +
                ", reason='" + reason + '\'' +
                ", ratings='" + ratings + '\'' +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
