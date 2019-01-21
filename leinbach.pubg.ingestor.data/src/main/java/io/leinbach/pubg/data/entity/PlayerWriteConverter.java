package io.leinbach.pubg.data.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.io.IOException;
import java.util.Map;

/**
 * @author leinb
 * @since 1/17/2019
 */
@WritingConverter
public class PlayerWriteConverter implements Converter<Map<String, Object>,String> {

    private static final Logger loggers = Loggers.getLogger(PlayerWriteConverter.class);

    private final ObjectMapper objectMapper;

    public PlayerWriteConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String convert(Map<String, Object> s) {
        try {
            return objectMapper.writeValueAsString(s);
        } catch (IOException e) {
            loggers.error("Failed to write entity", e);
            return null;
        }
    }
}
