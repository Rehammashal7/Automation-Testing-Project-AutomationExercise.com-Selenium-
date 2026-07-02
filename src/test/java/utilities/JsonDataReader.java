package utilities ;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JsonDataReader {

    public static JSONObject getJsonData(String filePath) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(data);
    }
}