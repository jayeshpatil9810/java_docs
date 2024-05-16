package com.demo.shutterstockApi.controller;

import com.demo.shutterstockApi.Service.FootageService;
import com.demo.shutterstockApi.dto.ResponseDto;

import com.demo.shutterstockApi.entity.Footage;
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
        path = "/api/shutterstock/footage",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class FootageController {

    @Autowired
    private FootageService footageService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FootageController.class);

    @PostMapping("/post-footage")
    public ResponseEntity<ResponseDto> postFootage(@Valid @RequestBody Footage[] footage) {
        try {
            for (Footage dataInfootage : footage) {
                LOGGER.info("DATA IN footage {}", dataInfootage);
                footageService.postFootage(dataInfootage);
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "Data posted successfully"));
        } catch (Exception e) {
            LOGGER.error("Error occurred while processing the request: {}", e.getMessage());
            LOGGER.error("Request body that caused the error: {}", Arrays.toString(footage));
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
