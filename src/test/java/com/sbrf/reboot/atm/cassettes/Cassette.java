package com.sbrf.reboot.atm.cassettes;

import java.util.ArrayList;
import java.util.List;

public class Cassette <T> extends Banknote {
    private List<T> banknote;

    public Cassette(List<T> banknote) {
        this.banknote = banknote;
    }

    int getCountBanknotes() {
        return banknote.size();
    }
}