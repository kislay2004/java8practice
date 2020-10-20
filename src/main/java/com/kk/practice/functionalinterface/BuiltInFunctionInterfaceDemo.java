package com.kk.practice.functionalinterface;

import com.kk.practice.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/*
* There are some built-in Functional interfaces in Java8 like Supplier, Consumer.
* */

public class BuiltInFunctionInterfaceDemo {

    static int id = 1;

    public static void main(String[] args) {
        // consumer, consumes the instance, does not return anything
        String newBooksTitle[] = {"HP1", "HP2", "HP3"};
        Arrays.asList(newBooksTitle).forEach( b -> assignLibraryId(b));

        // supplier, lets assign id from a supplier function
        Supplier<Long> supplier = () -> Math.round(Math.random()* 4.9);

        List<Book> newArrivals = new ArrayList<>();
        Arrays.asList(newBooksTitle).forEach((title) ->
                {
                    Book book = new Book(title);
                    book.setId( supplier.get());
                    newArrivals.add(book);
                }
        );
        newArrivals.forEach(System.out::println);

    }

    public static int getId(){
        return id++;
    }

    public static void assignLibraryId(String book){
        System.out.println("Id="+ id + ", for book:" + book);
        id++;
    }
}
