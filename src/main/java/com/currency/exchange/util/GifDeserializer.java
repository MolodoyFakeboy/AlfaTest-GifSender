package com.currency.exchange.util;

import com.currency.exchange.model.Gif;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class GifDeserializer  extends JsonDeserializer<Gif> {

    @Override
    public Gif deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode jsonNode = p.getCodec().readTree(p);
        JsonNode dataNode = jsonNode.get("data");
        return new Gif(dataNode.get("image_original_url").textValue());
    }

}
