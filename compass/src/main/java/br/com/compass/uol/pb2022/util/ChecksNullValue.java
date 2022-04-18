package br.com.compass.uol.pb2022.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ChecksNullValue {

    public static String checkNullValueMethod(Object o) {
        for (Field p : o.getClass().getDeclaredFields()) {
            try {
                if(p.get(o) == null) {
                    return p.getName();
                }
            } catch (IllegalArgumentException | IllegalAccessException ignored) {
                ignored.printStackTrace();
            }
        }
        return "";
    }
}
