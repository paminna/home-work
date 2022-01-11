package com.sbrf.reboot.repository.impl;
import java.io.*;
import java.util.Set;

import com.sbrf.reboot.repository.AccountRepository;

public class FileAccountRepository implements AccountRepository{

    public FileAccountRepository(String inputFile) {
        try(BufferedReader read = new BufferedReader(new FileReader(inputFile)))
        {

        }
        catch (FileNotFoundException e)
        {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        return null;
    }

    @Override
    public Set<Long> cardNumbers(long cardNum) {
        return null;
    }
}
