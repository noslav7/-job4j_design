package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(true, 39, new Contact("+7(908)92-67-339"),
                new String[] {"Full-time employee", "Busy"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":true,"
                        + "\"age\":39,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(908)92-67-339\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Full-time employee\",\"Busy\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
