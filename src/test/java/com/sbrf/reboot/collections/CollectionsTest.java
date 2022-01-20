package com.sbrf.reboot.collections;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import com.sbrf.reboot.collections.Stusents;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     */
    @Test
    public void addStudentToRating() {

        List<String> students = null;
        students = new ArrayList<>();
        students.add("Ivanov");
        students.add("Petrov");
        students.add("Sidorov");
        students.add("Kozlov");


        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = null;
        moneyBox = new HashSet<>();
        for (int i = 0; i < 10; i++)
            moneyBox.add(i + 1);
        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }
        Book first = new Book();
        Book second = new Book();
        Book third = new Book();

        Set<Book> bookshelf = null;
        bookshelf = new LinkedHashSet<>();
        bookshelf.add(first);
        bookshelf.add(second);
        bookshelf.add(third);

        assertEquals(3, bookshelf.size());
    }

// У нас есть блочная тетрадь с записями, мы удаляем старые листы из начала и вставляем новые листы в конец на каждой лекции

    @Test
    public void blockNotebook()
    {
        @Data
        class Notebook
        {
            String info;
        }
        Notebook page1 = new Notebook();
        page1.setInfo("Hello");

        Notebook page2 = new Notebook();
        page2.setInfo("Wish you a good day");

        Notebook page3 = new Notebook();
        page3.setInfo("Be happy");

        Notebook page4 = new Notebook();
        page4.setInfo("New page");

        LinkedList<Notebook> notebook = new LinkedList<>();
        notebook.addFirst(page1);
        notebook.add(page2);
        notebook.addLast(page3);

        System.out.println(notebook);

        notebook.pollFirst();
        notebook.addLast(page4);
        System.out.println(notebook);
        assertEquals(3, notebook.size());
    }

}