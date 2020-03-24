package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class JsonConverter {

    public static <T> T convertFromJson(String path, Class<T> objectClass) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new File(path), objectClass);

    }

}
