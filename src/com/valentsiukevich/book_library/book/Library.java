package com.valentsiukevich.book_library.book;

import com.valentsiukevich.book_library.util.Property;

import java.util.ArrayList;

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

    public ArrayList<Book> sortBy(Property property) {
        return new ArrayList<>();
    }

    public ArrayList<Book> find(int value, Property property) {
        ArrayList<Book> findBooks = new ArrayList<>();
        for (Book book : books) {
            if (Integer.valueOf(book.getValue(property).get(0)) == value) {
                findBooks.add(book);
            }
        }
        books = findBooks;
        return findBooks;
    }

    public ArrayList<Book> find(String value, Property property) {
        ArrayList<Book> findBooks = new ArrayList<>();
        value = value.toLowerCase();
        if (property != Property.YEAR_OF_PUBLISHING)
            for (Book book : books) {
                if ((book.getValue(property).get(0).toLowerCase()).contains(value)) {
                    findBooks.add(book);
                }
            }
        books = findBooks;
        return findBooks;
    }
    //------------------------------------------------------------------------------------------------------------------
}
