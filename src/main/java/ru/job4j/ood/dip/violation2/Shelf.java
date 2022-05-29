package ru.job4j.ood.dip.violation2;

import java.util.ArrayList;

public class Shelf {
    Book book;
    ArrayList<Book> bookShelf = new ArrayList<>();

    void addBook(Book book) {
          bookShelf.add(book);
    }

    Book retrieve(String name) {
        Book requiredBook = null;
        for (int i = 0; i < bookShelf.size(); i++) {
            if (bookShelf.get(i).heading.equals(name)) {
                requiredBook = bookShelf.remove(i);
            }
        }
        return requiredBook;
    }
}

/*
Для того чтобы у класса Shelf имелась возможность, наряду с классом Book использовать DVD,
в него необходимо внести изменения. Однако, это будет также нарушением OCP.
 */