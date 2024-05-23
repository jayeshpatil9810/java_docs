package com.demo.shutterstockApi.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.demo.shutterstockApi.entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;

@JsonComponent
public class ImageDeserializer extends JsonDeserializer<Image> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageDeserializer.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Image deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectNode node = jp.readValueAsTree();
        try {
            Image obj = new Image();

            // Deserialize verdict_time
            JsonNode verdictTimeNode = node.get("verdict_time");
            if (verdictTimeNode == null || verdictTimeNode.isNull()) {
                LOGGER.error("verdict_time is missing or null in the JSON input.");
                throw new IllegalArgumentException("verdict_time is required but is missing or null.");
            }
            String dateTimeStr = verdictTimeNode.asText();
            try {
                obj.setVerdict_time(LocalDateTime.parse(dateTimeStr, FORMATTER));
            } catch (DateTimeParseException e) {
                LOGGER.error("Failed to parse verdict_time: {}", dateTimeStr, e);
                throw new IllegalArgumentException("Invalid format for verdict_time: " + dateTimeStr);
            }

            // Deserialize other fields
            obj.setUser_name(getTextValue(node, "user_name", true));
            obj.setItem_id(getTextValue(node, "item_id", true));
            obj.setContributor(getTextValue(node, "contributor", false));
            obj.setVerdict(getTextValue(node, "verdict", false));
            obj.setReason(getTextValue(node, "reason", false));
            obj.setRatings(getTextValue(node, "ratings", false));
            obj.setTitle(getTextValue(node, "title", false));
            obj.setKeywords(getTextValue(node, "keywords", false));
            obj.setCategory(getTextValue(node, "category", false));
            obj.setSub_category(getTextValue(node, "sub_category", false));
            // Set other fields...

            return obj;
        } catch (IllegalArgumentException e) {
            LOGGER.error("IllegalArgumentException: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error during deserialization: {}", e.getMessage(), e);
            LOGGER.error("Request Body: {}", node.toString());
            throw new IOException("Error while deserializing Image object", e);
        }
    }

    private String getTextValue(ObjectNode node, String fieldName, boolean isRequired) {
        JsonNode fieldNode = node.get(fieldName);
        if (fieldNode != null && !fieldNode.isNull()) {
            return fieldNode.asText();
        } else if (isRequired) {
            LOGGER.error("{} is missing or null in the JSON input.", fieldName);
            throw new IllegalArgumentException(fieldName + " is required but is missing or null.");
        } else {
            return null; // or provide a default value if appropriate
        }
    }
}
