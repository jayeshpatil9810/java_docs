package com.demo.shutterstockApi.Service;

import com.demo.shutterstockApi.entity.Footage;
import com.demo.shutterstockApi.entity.Image;
import com.demo.shutterstockApi.repository.FootageRepository;

public interface FootageService {
    void postFootage(Footage footage);

}
