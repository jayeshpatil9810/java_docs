package com.demo.shutterstockApi.config;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import com.demo.shutterstockApi.exception.InvalidDurationFormatException;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class DurationDeserializer extends JsonDeserializer<Integer>{

    Logger LOGGER = LoggerFactory.getLogger(DurationDeserializer.class);

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
       return parseDuration(p.getValueAsString());
    }

    private int parseDuration(String durationStr) {
        try {
            if (durationStr.matches("\\d{2}:\\d{2}:\\d{2}")) {
                String[] parts = durationStr.split(":");
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                int seconds = Integer.parseInt(parts[2]);

                return hours * 3600 + minutes * 60 + seconds;
            } else {
                throw new InvalidDurationFormatException("Invalid duration format: " + durationStr);
            }
        } catch (Exception e) {
            LOGGER.error("Error parsing duration {} {}", durationStr, e.getMessage());
            throw new InvalidDurationFormatException("Error parsing duration: " + durationStr);
        }
    }

}
