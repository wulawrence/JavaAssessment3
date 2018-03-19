package parsing_json;

import com.google.gson.Gson;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ElementCollectionInitializer {
    public static ElementCollection generate() {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("periodic_table.json"));
            Result result = gson.fromJson(br, Result.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
