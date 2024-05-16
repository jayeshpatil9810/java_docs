package com.demo.shutterstockApi.ServiceImpl;

import com.demo.shutterstockApi.Service.FootageService;
import com.demo.shutterstockApi.entity.Footage;
import com.demo.shutterstockApi.repository.FootageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FootageServiceImple implements FootageService {

    @Autowired
    private FootageRepository footageRepository;


    @Override
    public void postFootage(Footage footage) {
        footageRepository.save(footage);

    }
}
