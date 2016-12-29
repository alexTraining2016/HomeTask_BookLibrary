package com.valentsiukevich.book_library.sort;

import com.valentsiukevich.book_library.book.Book;
import com.valentsiukevich.book_library.util.BookProperty;

import java.util.Comparator;

public class SortByNameDescending implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        String name1 = o1.getValue(BookProperty.NAME).get(0);
        String name2 = o2.getValue(BookProperty.NAME).get(0);
        return name2.compareTo(name1);
    }
}
