package com.sbrf.reboot.functionalinterface;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FunctionalInterfaceTest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class SomeObject {
        private String objectName;
    }

    @FunctionalInterface
    interface ObjectToJsonFunction<T> {
        String applyAsJson(T t) throws JsonProcessingException;
    }

    static class ListConverter<T> {
        public List<String> toJsonsList(@NonNull List<T> someObjects, ObjectToJsonFunction<T> objectToJsonFunction) throws JsonProcessingException {
            List<String> result = new ArrayList<>();
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");
            for (T obj : someObjects)
            {
                result.add(objectToJsonFunction.applyAsJson(obj));
            }
            return result;
        }
    }

    @Test
    public void successCallFunctionalInterface() throws JsonProcessingException {
        ListConverter<SomeObject> ListConverter = new ListConverter<>();

        ObjectToJsonFunction<SomeObject> objectToJsonFunction = someObject -> {
            ObjectWriter ow = new ObjectMapper().writer();
            return ow.writeValueAsString(someObject);
        };

        List<String> strings = ListConverter.toJsonsList(
                Arrays.asList(
                        new SomeObject("Object-1"),
                        new SomeObject("Object-2")
                ),
                objectToJsonFunction
        );

        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-1\"}"));
        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-2\"}"));
    }

}