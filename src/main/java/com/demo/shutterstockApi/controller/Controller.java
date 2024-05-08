package com.demo.shutterstockApi.controller;

import com.demo.shutterstockApi.dto.ResponseDto;
import com.demo.shutterstockApi.entity.Data;
import com.demo.shutterstockApi.service.DataService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(
        path = "/api/shutterstock",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class Controller {

    @Autowired
    DataService dataService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    
    @PostMapping("/post-data")
    public ResponseEntity<ResponseDto> postData(@Valid @RequestBody Data[] dump) {
        try {
            for (Data dataInDump : dump) {
                LOGGER.info("DATA IN DUMP {}", dataInDump);
                dataService.postData(dataInDump);
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "Data posted successfully"));
        } catch (Exception e) {
            LOGGER.error("Error occurred while processing the request: {}", e.getMessage());
            LOGGER.error("Request body that caused the error: {}", Arrays.toString(dump));
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto("500", "Internal Server Error"));
        }
    }

    @GetMapping("/get-data")
    public ResponseEntity<ResponseDto> getData() {
        LOGGER.error("Data retireved unsuccessfully", (Throwable) null);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200", "Data retrieved successfully"));
    }
}
