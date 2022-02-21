package com.sbrf.reboot.serialize;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class ToJSON {
    public String toJson () throws IOException {
        ClientData clientDataDto = new ClientData("Ivan", "Ivanov", "Ivanovich", 19273.73, 54);
        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer,clientDataDto);

        String result = writer.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String argc[]) throws IOException {
        ToJSON toJSON = new ToJSON();
        System.out.println(toJSON.toJson());
    }
}
