package com.demo.shutterstockApi.service;

import com.demo.shutterstockApi.dto.DataDto;
import com.demo.shutterstockApi.entity.Data;
import org.springframework.stereotype.Service;


public interface DataService {

    void postData(Data data);
}
