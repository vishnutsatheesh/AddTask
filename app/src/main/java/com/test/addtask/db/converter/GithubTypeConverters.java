package com.test.addtask.db.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.addtask.db.entity.Assignee;
import com.test.addtask.db.entity.Attachement;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GithubTypeConverters {


    @TypeConverter
    public static List<Assignee> stringtoAssignee(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Assignee>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String assigneeToString(List<Assignee> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static List<Attachement> stringtoAttachement(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Attachement>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String attachementToString(List<Attachement> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }
}
