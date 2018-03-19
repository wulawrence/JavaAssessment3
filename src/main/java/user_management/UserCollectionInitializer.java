package user_management;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserCollectionInitializer {
    public static UserCollection generate() {
        InputStream inputStream = UserCollection.class.getClassLoader().getResourceAsStream("users.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Gson gson = new GsonBuilder().create();
        UserCollection userCollection = gson.fromJson(reader, UserCollection.class);
        return userCollection;
    }
}
