package com.demo.shutterstockApi.config;

import com.demo.shutterstockApi.entity.Footage;
import com.demo.shutterstockApi.exception.InvalidDurationFormatException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FootageDeserializer extends JsonDeserializer<Footage> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FootageDeserializer.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Footage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode node = jp.readValueAsTree();
        return deserializeSingle(node, mapper);
    }

    private Footage deserializeSingle(JsonNode node, ObjectMapper mapper) throws IOException {
        try {
            Footage footage = new Footage();
            footage.setVerdict_time(parseVerdictTime(node));
            footage.setUser_name(getTextValue(node, "user_name"));
            footage.setItem_id(getTextValue(node, "item_id"));
            footage.setContributor(getTextValue(node, "contributor"));
            footage.setVerdict(getTextValue(node, "verdict"));
            footage.setReason(getTextValue(node, "reason"));
            footage.setRatings(getTextValue(node,"ratings"));
            footage.setRate(getTextValue(node, "rate"));
            footage.setTitle(getTextValue(node, "title"));
            footage.setKeywords(getTextValue(node, "keywords"));
            footage.setCategory(getTextValue(node, "category"));
            footage.setSub_category(getTextValue(node, "sub_category"));
            footage.setResolution(getTextValue(node, "resolution"));
            footage.setSize(getTextValue(node, "size"));
            footage.setRatio(getTextValue(node, "ratio"));
            footage.setDuration(parseDuration(getTextValue(node, "duration")));
            return footage;
        } catch (Exception e) {
            LOGGER.error("Error deserializing Footage object: {}", e.getMessage(), e);
            LOGGER.error("Request Body: {}", node.toString());
            throw new IOException("Error while deserializing Footage object", e);
        }
    }

    private LocalDateTime parseVerdictTime(JsonNode node) throws IOException {
        JsonNode verdictTimeNode = node.get("verdict_time");
        if (verdictTimeNode == null || verdictTimeNode.isNull()) {
            LOGGER.error("verdict_time is missing or null in the JSON input.");
            throw new IllegalArgumentException("verdict_time is required but is missing or null.");
        }
        String dateTimeStr = verdictTimeNode.asText();
        try {
            return LocalDateTime.parse(dateTimeStr, FORMATTER);
        } catch (DateTimeParseException e) {
            LOGGER.error("Failed to parse verdict_time: {}", dateTimeStr, e);
            throw new IllegalArgumentException("Invalid format for verdict_time: " + dateTimeStr, e);
        }
    }

    private String getTextValue(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return fieldNode != null ? fieldNode.asText() : null;
    }

    private Time parseDuration(String durationStr) {
        try {
            if (durationStr.matches("\\d{2}:\\d{2}:\\d{2}")) {
                String[] parts = durationStr.split(":");
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                int seconds = Integer.parseInt(parts[2]);
                return Time.valueOf(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            } else {
                throw new InvalidDurationFormatException("Invalid duration format: " + durationStr);
            }
        } catch (Exception e) {
            LOGGER.error("Error parsing duration '{}': {}", durationStr, e.getMessage(),e);
            throw new InvalidDurationFormatException("Error parsing duration: " + durationStr, e);
        }


    }
}
