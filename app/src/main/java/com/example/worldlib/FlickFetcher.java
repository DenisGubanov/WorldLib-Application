package com.example.worldlib;

import android.net.Uri;
import android.util.Log;

import com.example.worldlib.ui.news.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlickFetcher {
    private static final String TAG = "FlickFetcher";
    private static final String API_KEY = "AIzaSyBTf3JzBrhtuSG9N5e1ZqG9arYHnbpJ8Bc";

    public String GetJSONString(String UrlSpec) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(UrlSpec).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    public List<NewsItem> fetchItems() {
        List<NewsItem> newsItems = new ArrayList<>();
        try {
            String url = Uri.parse("https://api.flickr.com/services/rest/")
                    .buildUpon()
                    .appendQueryParameter("method", "flickr.photos.getRecent")
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("extras", "url_s")
                    .build().toString();
            String jsonString = GetJSONString(url);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(newsItems, jsonBody);

        } catch (JSONException e) {
            Log.e(TAG, "Ошибка парсинга JSON");
        } catch (IOException e) {
            Log.e(TAG, "Ошибка загрузки данных");
        }
        return newsItems;
    }

    private  void parseItems(List<NewsItem> items, JSONObject jsonBody) throws IOException, JSONException {
        JSONObject photosJsonObject = jsonBody.getJSONObject("photos");
        JSONArray photoJsonArray = photosJsonObject.getJSONArray("photo");

        for (int i = 0; i < photoJsonArray.length(); i++) {
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);
            NewsItem item = new NewsItem();
            item.setId(photoJsonObject.getString("id"));
            item.setTitle(photoJsonObject.getString("title"));
            item.setAuthor(photoJsonObject.getString("author"));
            item.setBody(photoJsonObject.getString("body"));
            item.setStart(photoJsonObject.getString("data"));
            if(!photoJsonObject.has("url_s")) {
                continue;
            }
            item.setUrl(photoJsonObject.getString("url_s"));
            items.add(item);
        }
    }
}
