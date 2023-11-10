package info.hccis.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiProcessor {

    public static String callApi(String location) {
        try {
            String encoded = URLEncoder.encode(location);
           String apiKey = "6f043c80af58908663c57ab081710c14"; 
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey;
           
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();
     
      com.google.gson.Gson gson = new com.google.gson.Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

           if (jsonObject.has("weather")) {
                JsonArray weatherArray = jsonObject.getAsJsonArray("weather");
                if (weatherArray.size() > 0) {
                    JsonObject weatherInfo = weatherArray.get(0).getAsJsonObject();
                    if (weatherInfo.has("main")) {
                        String weatherMain = weatherInfo.get("main").getAsString();
                        return weatherMain;
                    }
                }
            }
            
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching weather data";
        }
    }
}
