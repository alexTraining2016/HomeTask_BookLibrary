package com.valentsiukevich.book_library.book;

import com.valentsiukevich.book_library.sort.*;
import com.valentsiukevich.book_library.util.*;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
    // ПОЛЯ
    //------------------------------------------------------------------------------------------------------------------
    private ArrayList<Book> baseBooks;
    private ArrayList<Book> books;
    //------------------------------------------------------------------------------------------------------------------

    // КОНСТРУКТОРЫ
    //------------------------------------------------------------------------------------------------------------------
    private Library(ArrayList<Book> newBooks) {
        books = newBooks;
    }

    public Library() {
        this(new ArrayList<>());
    }
    //------------------------------------------------------------------------------------------------------------------

    // МЕТОДЫ
    //------------------------------------------------------------------------------------------------------------------
    public void setBooks(ArrayList<Book> newBooks) {
        books = newBooks;
        baseBooks = newBooks;
    }

    public Book get(int index) {
        return books.get(index);
    }

    public int size() {
        return books.size();
    }

    public void add(int index, Book book) {
        books.add(index, book);
    }

    public boolean add(Book book) {
        return books.add(book);
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public void reset() {
        books = new ArrayList<>(baseBooks);
    }

    public ArrayList<Book> sortBy(BookProperty bookProperty, SortProperty sortProperty) {
        switch (sortProperty) {
            case ASCENDING: {
                switch (bookProperty) {
                    case NAME:
                        Collections.sort(books, new SortByNameAscending());
                        return books;
                }
            }
            case DESCENDING: {
                switch (bookProperty) {
                    case NAME:
                        Collections.sort(books, new SortByNameDescending());
                        return books;
                }
            }
            break;
        }
        return books;
    }

    public ArrayList<Book> find(int value, BookProperty bookProperty) {
        if (bookProperty != BookProperty.YEAR_OF_PUBLISHING) {
            books = new ArrayList<>();
            return books;
        }
        ArrayList<Book> findBooks = new ArrayList<>();
        for (Book book : books) {
            if (Integer.valueOf(book.getValue(bookProperty).get(0)) == value) {
                findBooks.add(book);
            }
        }
        books = findBooks;
        return books;
    }

    public ArrayList<Book> find(String value, BookProperty bookProperty) {
        if (bookProperty == BookProperty.YEAR_OF_PUBLISHING) {
            books = new ArrayList<>();
            return books;
        }
        ArrayList<Book> findBooks = new ArrayList<>();
        value = value.toLowerCase();
        for (Book book : books) {
            if ((book.getValue(bookProperty).get(0).toLowerCase()).contains(value)) {
                findBooks.add(book);
            }
        }
        books = findBooks;
        return books;
    }
    //------------------------------------------------------------------------------------------------------------------
}
