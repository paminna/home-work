package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.*;

public class AccountService {

    @NonNull
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isClientHasContract(long clientId, long contractNumber)
    {
        return accountRepository.getAllAccountsByClientId(clientId).contains(contractNumber);
    }

    public boolean isCardNumberExist(long cardNum, long clientId)
    {
        return  accountRepository.getAllAccountsByClientId(clientId).contains(cardNum);
    }

}
