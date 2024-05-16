package com.demo.shutterstockApi.repository;

import com.demo.shutterstockApi.entity.Footage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootageRepository extends JpaRepository<Footage,Integer> {

}
