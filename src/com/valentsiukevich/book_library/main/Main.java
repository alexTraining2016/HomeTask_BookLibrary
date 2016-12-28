package com.valentsiukevich.book_library.main;

import com.valentsiukevich.book_library.book.Library;
import com.valentsiukevich.book_library.console.Display;
import com.valentsiukevich.book_library.reader.ReadFile;
import com.valentsiukevich.book_library.util.Property;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.setBooks(ReadFile.readAllBooks("file.txt"));
        Display.displayLibrary(library);
        library.find("волшебники!", Property.NAME);
        Display.displayLibrary(library);
    }
}
