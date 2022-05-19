package com.example.helpingfrog.mapper;

import com.example.helpingfrog.domain.Author;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthorMapper {

    public static Author authorFromJson(JSONObject jsonObject) {

        Author author = null;

        try {
            author = new Author(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return author;
    }

    public static Author authorFromTaskJson(JSONObject jsonObject) {

        Author author = null;
        try {
            author = authorFromJson(jsonObject.getJSONObject("authorDto"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
// проваливаемся внутрь json без переиспользования метода(долго, но понятно, че мы делаем)
//        try {
//            author = new Author(
//                    jsonObject.getJSONObject("authorDto").getInt("id"),
//                    jsonObject.getJSONObject("authorDto").getString("name")
//            );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        return author;
    }
}
