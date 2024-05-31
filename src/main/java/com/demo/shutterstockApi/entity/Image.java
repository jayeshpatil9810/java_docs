package com.demo.shutterstockApi.entity;

import com.demo.shutterstockApi.config.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime verdict_time;

    private String user_name;

    private String item_id;

    private String contributor;

    private String verdict;

    private String reason;

    private String ratings;

    private String title;

    private String keywords;

    private String category;
    private String sub_category;

    public Image() {

    }

    // All args constructor
    public Image(int id, LocalDateTime verdict_time, String user_name, String item_id, String contributor,
            String verdict, String reason, String ratings, String title, String keywords, String category,
            String sub_category) {
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
        this.category = category;
        this.sub_category = sub_category;
    }

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

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub_category() {
        return sub_category;
    }

    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", verdict_time=" + verdict_time +
                ", user_name='" + user_name + '\'' +
                ", item_id='" + item_id + '\'' +
                ", contributor='" + contributor + '\'' +
                ", verdict='" + verdict + '\'' +
                ", reason='" + reason + '\'' +
                ", ratings='" + ratings + '\'' +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", category='" + category + '\'' +
                ", sub_category='" + sub_category + '\'' +
                '}';
    }
}
