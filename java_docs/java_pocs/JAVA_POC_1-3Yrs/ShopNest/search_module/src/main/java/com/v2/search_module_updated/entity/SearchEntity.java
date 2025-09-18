package com.v2.search_module_updated.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SearchEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productID;
	private String productName;
	private String description;
}
