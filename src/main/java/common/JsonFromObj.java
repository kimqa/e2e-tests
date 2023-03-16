package common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonFromObj {
    public String jsonFromObj(Object obj) {
        try {
            String message;
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return message = ow.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
