package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveElementWithoutErrorsTest {

    @Test
    public void successConcurrentModificationException() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {

            for (Integer integer : list) {
                list.remove(1);
            }

        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        Assertions.assertDoesNotThrow(() -> {
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext())
            {
                Integer nextNum = iterator.next();
                iterator.remove();
            }
        });
    }


    @Test
    public void successRemoveElementWithoutErrorsFivePlus() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        Assertions.assertDoesNotThrow(() -> {
            list.removeAll(list);
        });
    }

    @Test
    public void successRemoveElementWithoutErrorsFivePlusPlus() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> toDelete = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};


        Assertions.assertDoesNotThrow(() -> {
            for (Integer sym: toDelete)
            {
                list.remove(sym);
            }
        });
    }
}