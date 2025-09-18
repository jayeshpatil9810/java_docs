package com.demo.shutterstockApi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "footage_reasons")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class FootageReason {

    @Id
    @Column(name = "review_id", insertable = false, updatable = false)
    private Long reviewId;

    private String reason;

}
