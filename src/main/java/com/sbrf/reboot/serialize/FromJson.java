package com.sbrf.reboot.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;

public class FromJson {
    public static ClientData fromJson() throws IOException {
        String result = "{\"name\":\"Ivan\",\"secondName\":\"Ivanov\",\"patronymic\":\"Ivanovich\",\"balance\":19273.73,\"accountNumber\":54}";
        StringReader reader = new StringReader(result);
        ObjectMapper mapper1 = new ObjectMapper();

        ClientData clientDataDto = mapper1.readValue(reader, ClientData.class);
        return clientDataDto;
    }

    public static void main(String argc[]) throws IOException {
        FromJson from = new FromJson();
//        System.out.println(FromJson.fromJson());
    }
}
