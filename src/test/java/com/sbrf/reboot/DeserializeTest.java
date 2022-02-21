package com.sbrf.reboot;

import com.sbrf.reboot.serialize.ClientData;
import com.sbrf.reboot.serialize.FromJson;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeserializeTest
{
    @Test
    void from() throws IOException
    {
        FromJson fromJson = new FromJson();
        ClientData res = fromJson.fromJson();
        assertEquals( res.getAccountNumber(), 54);
    }
}
