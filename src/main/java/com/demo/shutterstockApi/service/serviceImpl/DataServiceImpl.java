package com.demo.shutterstockApi.service.serviceImpl;

import com.demo.shutterstockApi.dto.DataDto;
import com.demo.shutterstockApi.entity.Data;
import com.demo.shutterstockApi.mapper.DataMapper;
import com.demo.shutterstockApi.repository.DataRepository;
import com.demo.shutterstockApi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataRepository dataRepo;

    @Override
    public void postData(Data data) {
        dataRepo.save(data);
    }
}
