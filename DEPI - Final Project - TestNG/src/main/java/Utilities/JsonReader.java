package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.io.File;

public class JsonReader {
    public static Map<String, String> read_data_file(String file_path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(file_path), Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get_value(String file_path, String key) { return read_data_file(file_path).get(key); }
}
