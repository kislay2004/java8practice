package com.kk.practice.lamdaexpression;

import com.kk.practice.model.Book;

/**
 * lambda expression to print the name. print is a behaviour we want to pass to Book.
 */
public class LambdaExpressionIntro {

    public static void main(String[] args) {

        String name = "Harry Potter -1";
        final Book book = new Book(name);

        // lambda expression as implementation of a functional interface. (method)
        PrintService printService = (bookToPrint )-> System.out.println("The book's name is:" + bookToPrint.getName());
        printService.print(book);
        //Book's scope should be effectively final.. what does that mean? and Why?

    }

}
