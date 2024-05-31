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
import java.time.format.DateTimeParseException;

@JsonComponent
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeDeserializer.class);

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            return LocalDateTime.parse(p.getValueAsString(), formatter);
        } catch (DateTimeParseException e) {
            LOGGER.error("Failed to parse date time: {}", p.getValueAsString(), e.getMessage());
            throw new IOException("Failed to parse date time", e);
        }
    }
}