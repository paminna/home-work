package com.sbrf.reboot.repository.impl;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.io.FileNotFoundException;
import com.sbrf.reboot.repository.AccountRepository;
import lombok.SneakyThrows;


public class FileAccountRepository implements AccountRepository{

    HashMap<Long, Set<Long>> allAccounts = new HashMap<>();
    public FileAccountRepository(String inputFile) throws IOException {
        try(BufferedReader read = new BufferedReader(new FileReader(inputFile)))
        {
            StringBuilder line = new StringBuilder();
            String tmp;

            while ((tmp = read.readLine()) != null)
            {
                line.append(tmp);
                line.append(System.lineSeparator());
            }
            FillSet(line);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public void FillSet(StringBuilder tmp)
    {
        String s = tmp.toString();
        char [] arr = s.toCharArray();
        long clientId = 0;
        long num = 0;
        long tmpNum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (arr[i] == ':') {
                i += 2;
                while (isDigit(arr[i])) {
                    tmpNum = tmpNum * 10 + arr[i] - '0';
                    i++;
                }
                if (arr[i] == ',')
                    clientId = tmpNum;
                else
                    num = tmpNum;
                tmpNum = 0;
            }
            if (clientId == 0)
                continue;
            if (num != 0)
            {
                if (allAccounts.containsKey(clientId))
                {
                    allAccounts.get(clientId).add(num);
                    allAccounts.put(clientId, allAccounts.get(clientId));
                }
                else
                {
                    Set<Long> helper = new HashSet<>();
                    helper.add(num);
                    allAccounts.put(clientId, helper);
                }
                num = 0;
            }
        }
    }

    public boolean isDigit(char a)
    {
        if (a >= 48 && a <= 57)
            return true;
        return false;
    }
    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        return allAccounts.get(clientId);
    }

    @Override
    public Set<Long> cardNumbers(long cardNum) {
        return null;
    }


}
