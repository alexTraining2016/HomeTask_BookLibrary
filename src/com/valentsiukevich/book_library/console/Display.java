package com.valentsiukevich.book_library.console;

import com.valentsiukevich.book_library.book.Library;

public class Display {
    public static void displayLibrary(Library library) {
        if (library.isEmpty()) {
            System.out.println("elements not found!");
            return;
        }
        String DECORATION;
        DECORATION = "------------------------------------------------------------------------------------------------------------------------";
        for (int i = 0; i < library.size(); i++) {
            System.out.println(DECORATION);
            System.out.println(library.get(i));
        }
        System.out.println(DECORATION);
    }
}
