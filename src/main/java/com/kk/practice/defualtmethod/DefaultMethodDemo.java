package com.kk.practice.defualtmethod;

import java.util.Arrays;
import java.util.List;

public class DefaultMethodDemo {

    public static void main(String[] args) {

        BookInventory bookInventory = new BookInventoryImpl();

        bookInventory.addBook("An interesting book");

        // calling a default method here.
        System.out.println(bookInventory.briefSummary(1));

        // static method
        List<String> booksNames = Arrays.asList("Clifton chronicles", "Life of Pi", "Becoming Steve Jobs");
        BookInventory.printBooks(booksNames);


    }
}

interface BookInventory{


    void addBook(String bookName);
    String retrieveBook(int bookId) ;

    static void printBooks(List<String> bookList){
        bookList.forEach(System.out:: println);
    }

    default String briefSummary(int bookId){
        System.out.println("Fetching brief summary");
        return "Brief Summary of the book :"+ bookId;
    }

}

class BookInventoryImpl implements BookInventory{

    @Override
    public void addBook(String bookName) {
        System.out.println("adding book"+ bookName );
    }

    @Override
    public String retrieveBook(int bookId) {
        return "book#"+ bookId;
    }
}


