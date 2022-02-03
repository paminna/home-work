package com.sbrf.reboot.serialize;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonAutoDetect
public class ClientData {
    String name;
    String secondName;
    String patronymic;
    Double balance;
    Integer accountNumber;

    public ClientData() {};

    public ClientData(String ivan, String ivanov, String ivanovich, double v, int i)
    {
        setName(ivan);
        setSecondName(ivanov);
        setPatronymic(ivanovich);
        setBalance(v);
        setAccountNumber(i);
    }
}
