package com.wisedu.fam.help;

import java.lang.reflect.Type;
import java.text.*;
import java.util.Date;

import com.google.gson.*;

public class FooDeserializer implements JsonDeserializer<Foo> {

     public Foo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String a = json.getAsJsonObject().get("date").getAsString();
        String b = json.getAsJsonObject().get("created_at").getAsString();

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfDateWithTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Date date, created;
        try {
           date = sdfDate.parse(a);
           created = sdfDateWithTime.parse(b);
        } catch (ParseException e) {
           throw new RuntimeException(e);
        }

        return new Foo(date, created);
    }

}