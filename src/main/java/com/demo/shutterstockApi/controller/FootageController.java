package com.demo.shutterstockApi.controller;

import com.demo.shutterstockApi.Service.FootageService;
import com.demo.shutterstockApi.dto.ResponseDto;
import com.demo.shutterstockApi.entity.Footage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(
        path = "/api/shutterstock/footage",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class FootageController {

    @Autowired
    private FootageService footageService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FootageController.class);

    @PostMapping("/post-footage")
    public ResponseEntity<ResponseDto> postFootage(@Valid @RequestBody JsonNode jsonNode) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (jsonNode.isArray()) {
                Footage[] footageArray = mapper.treeToValue(jsonNode, Footage[].class);
                for (Footage dataInFootage : footageArray) {
                    LOGGER.info("DATA IN footage {}", dataInFootage);
                    footageService.postFootage(dataInFootage);
                }
            } else {
                Footage footage = mapper.treeToValue(jsonNode, Footage.class);
                LOGGER.info("DATA IN footage {}", footage);
                footageService.postFootage(footage);
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "Data posted successfully"));
        } catch (Exception e) {
            LOGGER.error("Error occurred while processing the request: {}", e.getMessage(), e);
            LOGGER.error("Request body that caused the error: {}", jsonNode.toString());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto("500", "Internal Server Error"));
        }
    }

    @GetMapping("/get-data")
    public ResponseEntity<ResponseDto> getData() {
        LOGGER.info("Data retrieved successfully");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200", "Data retrieved successfully"));
    }
}
