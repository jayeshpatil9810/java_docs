package com.demo.shutterstockApi.controller;

import com.demo.shutterstockApi.dto.DataDto;
import com.demo.shutterstockApi.dto.ResponseDto;
import com.demo.shutterstockApi.entity.Data;
import com.demo.shutterstockApi.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/api/shutterstock",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class Controller {

    @Autowired
    DataService dataService;

    @PostMapping("/post-data")
    public ResponseEntity<ResponseDto> postData(@RequestBody Data[] data) {
        for (Data datas : data) {
            dataService.postData(datas);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200", "Data posted successfully"));
    }
}
