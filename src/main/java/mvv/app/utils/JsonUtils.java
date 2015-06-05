package mvv.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * Created by manh.vu on 6/4/2015.
 */
public class JsonUtils {
    private static final Logger log = LogManager.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }

    public static String objectToJson(Object obj) {
        String json = "";

        try {
            json = getObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

        return json;
    }

    public static String getPrettyJson(Objects obj) {
        String json = "";

        try {
            json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

        return json;
    }
}
