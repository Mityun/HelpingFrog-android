package com.example.helpingfrog.mapper;

import com.example.helpingfrog.domain.Importance;

import org.json.JSONException;
import org.json.JSONObject;

public class ImportanceMapper {


    public static Importance importanceFromJson(JSONObject jsonObject) {

        Importance importance = null;

        try {
            importance = new Importance(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return importance;
    }

    public static Importance importanceFromTaskJson(JSONObject jsonObject) {

        Importance importance = null;
        try {
            importance = importanceFromJson(jsonObject.getJSONObject("importanceDto"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
// проваливаемся внутрь json без переиспользования метода(долго, но понятно, че мы делаем)
//        try {
//            importance = new Importance(
//                    jsonObject.getJSONObject("importanceDto").getInt("id"),
//                    jsonObject.getJSONObject("importanceDto").getString("name")
//            );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        return importance;
    }
}
