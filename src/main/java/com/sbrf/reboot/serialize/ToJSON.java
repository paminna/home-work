package com.sbrf.reboot.serialize;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class ToJSON {
    public static void main(String[] args) throws IOException {
        ClientDataDto clientDataDto = new ClientDataDto("Ivan", "Ivanov", "Ivanovich", 19273.73, 54);
        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer,clientDataDto);

        String result = writer.toString();
        System.out.println("Serialized");
        System.out.println(result);

        StringReader reader = new StringReader(result);
        ObjectMapper mapper1 = new ObjectMapper();

        ClientDataDto clientDataDto1 = mapper1.readValue(reader, ClientDataDto.class);
        System.out.println("Deserialized");
        System.out.println(clientDataDto1.getName());
        System.out.println(clientDataDto1.getSecondName());
        System.out.println(clientDataDto1.getPatronymic());
        System.out.println(clientDataDto1.getBalance());
        System.out.println(clientDataDto1.getAccountNumber());
    }
}
