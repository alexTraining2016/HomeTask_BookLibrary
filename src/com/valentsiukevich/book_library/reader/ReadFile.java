package com.valentsiukevich.book_library.reader;

import com.valentsiukevich.book_library.book.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ReadFile {
    public static ArrayList<Book> readAllBooks(String nameTextFile) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameTextFile));
            String nameBook;
            while ((nameBook = reader.readLine()) != null) {
                books.add(readBook("Books/" + nameBook));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return books;
    }

    private static Book readBook(String nameTextFile) {
        Book book = new Book();
        HashMap<String, ArrayList<String>> properties = getProperties(nameTextFile);
        book.setName(properties.get("[NAME]"));
        book.setRating(properties.get("[RATING]"));
        book.setAuthor(properties.get("[AUTHOR]"));
        book.setYearOfPublishing(properties.get("[YEAR_OF_PUBLISHING]"));
        book.setDescription(properties.get("[DESCRIPTION]"));
        return book;
    }

    private static HashMap<String, ArrayList<String>> getProperties(String nameTextFile) {
        HashMap<String, ArrayList<String>> properties = new HashMap<>();
        ArrayList<String> valueTemp;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameTextFile));
            String property;
            while ((property = reader.readLine()) != null) {
                String[] splitProperty = property.split(" ");
                String key = splitProperty[0];
                String value = "";
                for (int i = 1; i < splitProperty.length - 1; i++) {
                    value += splitProperty[i] + " ";
                }
                value += splitProperty[splitProperty.length - 1];
                if (properties.get(key) != null) {
                    valueTemp = properties.get(key);
                } else {
                    valueTemp = new ArrayList<>();
                }
                valueTemp.add(value);
                properties.put(key, valueTemp);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return properties;
    }
}
