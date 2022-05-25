package com.example.helpingfrog.mapper;

import com.example.helpingfrog.domain.Task;
import com.example.helpingfrog.domain.User;

import org.json.JSONException;
import org.json.JSONObject;

public class UserMapper {

    public static User userFromJson(JSONObject jsonObject) {

        User user = null;

        try {
            user = new User(
                    jsonObject.getInt("id"),
                    jsonObject.getString("login"),
                    jsonObject.getString("password"),
                    jsonObject.getInt("totalHours")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }
}
