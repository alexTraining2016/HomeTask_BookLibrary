package com.valentsiukevich.book_library.book;

import com.valentsiukevich.book_library.util.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Book {
    // ПОЛЯ
    //------------------------------------------------------------------------------------------------------------------
    private Map<Property, ArrayList<String>> properties;
    //------------------------------------------------------------------------------------------------------------------

    // КОНСТРУКТОРЫ
    //------------------------------------------------------------------------------------------------------------------
    public Book() {
        properties = new LinkedHashMap<>();
    }
    //------------------------------------------------------------------------------------------------------------------

    // МЕТОДЫ
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Changes the name of a book
     *
     * @param newName the new name of the book
     */
    public void setName(ArrayList<String> newName) {
        if (newName == null) {
            newName = new ArrayList<>();
            newName.add("");
        }
        properties.put(Property.NAME, new ArrayList<>(Collections.singletonList(newName.get(0))));
    }

    /**
     * Changes the rating of a book
     *
     * @param newRating the new rating of the book
     */
    public void setRating(ArrayList<String> newRating) {
        if (newRating == null) {
            newRating = new ArrayList<>();
            newRating.add("-1");
        }
        properties.put(Property.RATING, new ArrayList<>(Collections.singletonList(newRating.get(0))));
    }

    /**
     * Changes the authors of a book
     *
     * @param newAuthors the new authors of the book
     */
    public void setAuthor(ArrayList<String> newAuthors) {
        if (newAuthors == null) {
            newAuthors = new ArrayList<>();
            newAuthors.add("");
        }
        properties.put(Property.AUTHOR, newAuthors);
    }

    /**
     * Changes the year of publishing of a book
     *
     * @param newYearOfPublishing the new year of publishing of the book
     */
    public void setYearOfPublishing(ArrayList<String> newYearOfPublishing) {
        if (newYearOfPublishing == null) {
            newYearOfPublishing = new ArrayList<>();
            newYearOfPublishing.add("-1");
        }
        properties.put(Property.YEAR_OF_PUBLISHING, new ArrayList<>(Collections.singletonList(newYearOfPublishing.get(0))));
    }

    /**
     * Changes the description of a book
     *
     * @param newDescription the new description of the book
     */
    public void setDescription(ArrayList<String> newDescription) {
        if (newDescription == null) {
            newDescription = new ArrayList<>();
            newDescription.add("");
        }
        properties.put(Property.DESCRIPTION, newDescription);
    }

    private String getStringName() {
        return properties.get(Property.NAME).get(0);
    }

    private String getStringRating() {
        String stringRating = "";
        for (int i = 0; i < Integer.valueOf(properties.get(Property.RATING).get(0)); i++) {
            stringRating += "✯";
        }
        return stringRating;
    }

    private String getStringAuthors() {
        String stringAuthors = "";
        for (int i = 0; i < properties.get(Property.AUTHOR).size(); i++) {
            stringAuthors += properties.get(Property.AUTHOR).get(i) + ", ";
        }
        return stringAuthors;
    }

    private String getStringYearOfPublishing() {
        return properties.get(Property.YEAR_OF_PUBLISHING).get(0);
    }

    private String getStringDescription() {
        String stringDescription = properties.get(Property.DESCRIPTION).get(0);
        for (int i = 1; i < properties.get(Property.DESCRIPTION).size(); i++) {
            stringDescription += "\n" + properties.get(Property.DESCRIPTION).get(i);
        }
        return stringDescription;
    }

    ArrayList<String> getValue(Property property) {
        return properties.get(property);
    }

    @Override
    public String toString() {
        return (getStringName() +
                "\n" +
                getStringRating() +
                "\n" +
                getStringAuthors() +
                getStringYearOfPublishing() +
                "\n" +
                getStringDescription());
    }
    //------------------------------------------------------------------------------------------------------------------
}
