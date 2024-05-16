package com.demo.shutterstockApi.config;

import com.demo.shutterstockApi.entity.Footage;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FootageDeserializer extends JsonDeserializer<Footage> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FootageDeserializer.class);

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Footage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectNode node = jp.readValueAsTree();
        try {
            Footage obj = new Footage();
            String dateTimeStr = node.get("verdict_time").asText();
            obj.setVerdict_time(LocalDateTime.parse(dateTimeStr, formatter));
            obj.setUser_name(node.get("user_name").asText());
            obj.setItem_id(node.get("item_id").asText());
            obj.setContributor(node.get("contributor").asText());
            obj.setVerdict(node.get("verdict").asText());
            obj.setReason(node.get("reason").asText());
            obj.setRate(node.get("rate").asText());
            obj.setTitle(node.get("title").asText());
            obj.setKeywords(node.get("keywords").asText());
            obj.setCategory(node.get("category").asText());
            obj.setSub_category(node.get("sub_category").asText());
            obj.setResolution(node.get("resolution").asText());
            obj.setSize(node.get("size").asText());
            obj.setRatio(node.get("ratio").asText());
            // Set other fields...

            return obj;
        } catch (Exception e) {
            LOGGER.error("ERROR at verdict_time deserialization {}", e.getMessage());
            LOGGER.error("Request Body {}", node.toString());
            throw new IOException("Error while deserializing Footage object", e);
        }
    }
}
