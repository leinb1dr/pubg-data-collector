package io.leinbach.pubg.data.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.io.IOException;
import java.util.Map;

/**
 * @author leinb
 * @since 1/17/2019
 */
@ReadingConverter
public class PlayerReadConverter implements Converter<String, Map<String, Object>> {

    private static final Logger loggers = Loggers.getLogger(PlayerReadConverter.class);

    private final ObjectMapper objectMapper;

    public PlayerReadConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Map<String, Object> convert(String s) {
        try {
            return objectMapper.readValue(s, new TypeReference<Map<String, Object>>(){});
        } catch (IOException e) {
            loggers.error("Failed to read entity", e);
            return null;
        }
    }
}
