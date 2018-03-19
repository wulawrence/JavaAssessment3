package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.transform.Result;
import java.io.*;

public class ElementCollectionInitializer {
    public static ElementCollection generate() {
        InputStream inputStream = ElementCollection.class.getClassLoader().getResourceAsStream("periodic_table.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Gson gson = new GsonBuilder().create();
        ElementCollection elementCollection = gson.fromJson(reader, ElementCollection.class);
        return elementCollection;
    }
}
