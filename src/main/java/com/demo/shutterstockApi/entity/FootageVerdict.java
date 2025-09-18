package com.demo.shutterstockApi.entity;

import java.time.LocalDateTime;

import com.demo.shutterstockApi.config.DurationDeserializer;
import com.demo.shutterstockApi.config.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "footage_verdict")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class FootageVerdict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "review_id")
    private int reviewId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime verdict_time;
    
    @Column(name = "user_name")
    private String userName;

    @Column(name = "item_id")
    private String itemId;
    private String contributor;
    private String verdict;
    private String ratings;
    private String title;
    private String category;

    @Column(name = "sub_category")
    private String subCategory;
    private String resolution;
    private String rate;
    private String ratio;
    private String size;

    @JsonDeserialize(using = DurationDeserializer.class)
    private int duration;
}
