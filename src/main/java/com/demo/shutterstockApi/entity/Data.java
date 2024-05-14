package com.demo.shutterstockApi.entity;


import com.demo.shutterstockApi.config.DumpDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "dump")
@JsonDeserialize(using = DumpDeserializer.class)
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime verdict_time;

    private String user_name;

    private String item_id;

    private String contributor;

    private String verdict;

    private String reason;

    private String ratings;

    private String title;

    private String keywords;


    // All args constructor
    public Data(int id, LocalDateTime verdict_time, String user_name, String item_id, String contributor, String verdict, String reason, String ratings, String title, String keywords) {
        this.id = id;
        this.verdict_time = verdict_time;
        this.user_name = user_name;
        this.item_id = item_id;
        this.contributor = contributor;
        this.verdict = verdict;
        this.reason = reason;
        this.ratings = ratings;
        this.title = title;
        this.keywords = keywords;
    }

    // no args constructor
    public Data() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getVerdict_time() {
        return verdict_time;
    }

    public void setVerdict_time(LocalDateTime verdict_time) {
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

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    // toString
    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", verdict_time='" + verdict_time + '\'' +
                ", user_name='" + user_name + '\'' +
                ", item_id='" + item_id + '\'' +
                ", contributor='" + contributor + '\'' +
                ", verdict='" + verdict + '\'' +
                ", reason='" + reason + '\'' +
                ", ratings='" + ratings + '\'' +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
