package com.demo.shutterstockApi.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonComponent
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeDeserializer.class);

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            return LocalDateTime.parse(p.getValueAsString(), formatter);
        } catch (Exception e) {
            LOGGER.error("Error occurred during deserialization: {}", e.getMessage());
            LOGGER.error("Request body received: {}", p.getCurrentValue());
            throw e;
        }
    }
}