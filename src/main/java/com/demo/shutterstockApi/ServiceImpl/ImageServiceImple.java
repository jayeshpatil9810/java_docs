package com.demo.shutterstockApi.ServiceImpl;

import com.demo.shutterstockApi.Service.ImageService;
import com.demo.shutterstockApi.entity.Image;
import com.demo.shutterstockApi.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImple implements ImageService {
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public void postImage(Image image) {
        imageRepository.save(image);
    }
}
