package com.sbrf.reboot;

import com.sbrf.reboot.serialize.ToJSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeTest
{
    @Test
    void toJson() throws IOException {
        ToJSON toJSON = new ToJSON();
        String res = toJSON.toJson();
        assertEquals(res, "{\"name\":\"Ivan\",\"secondName\":\"Ivanov\",\"patronymic\":\"Ivanovich\",\"balance\":19273.73,\"accountNumber\":54}");
    }
}
