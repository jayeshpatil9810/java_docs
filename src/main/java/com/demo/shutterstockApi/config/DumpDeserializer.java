package com.demo.shutterstockApi.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import com.demo.shutterstockApi.entity.Data;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonComponent
public class DumpDeserializer extends JsonDeserializer<Data>{
    private static final Logger LOGGER = LoggerFactory.getLogger(DumpDeserializer.class);
    // private static final LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");


    @Override
    public Data deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectNode node = jp.readValueAsTree();
        try {
            Data obj = new Data();
            // Assuming verdict_time is the field that needs to be parsed as LocalDateTime
            String dateTimeStr = node.get("verdict_time").asText();
            obj.setVerdict_time(LocalDateTime.parse(dateTimeStr, formatter));
            obj.setUser_name(node.get("user_name").asText());
            obj.setItem_id(node.get("item_id").asText());
            obj.setContributor(node.get("contributor").asText());
            obj.setVerdict(node.get("verdict").asText());
            obj.setReason(node.get("reason").asText());
            obj.setRatings(node.get("ratings").asText());
            obj.setTitle(node.get("title").asText());
            obj.setKeywords(node.get("keywords").asText());
            // Set other fields...

            return obj;
        } catch (Exception e) {
            LOGGER.error("ERROR at verdict_time deserialization {}", e.getMessage());
            LOGGER.error("Request Body {}", node.toString());
            throw e;
        }
    }
}
