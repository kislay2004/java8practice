package com.kk.practice.lamdaexpression;

import com.kk.practice.model.Book;
import com.kk.practice.model.FavGenre;
import com.kk.practice.model.Reader;

import java.util.Arrays;

/*
*
* */
public class MethodReferenceDemo {

    public static void main(String[] args) {

        String name = "Harry Potter -1";
        final Book book = new Book(name);

        // lambda expression as implementation of a functional interface. (method)
        PrintService printService = (bookToPrint) -> System.out.println("The book's name is:" + bookToPrint.getName());
        printService.print(book);

        //Now,  assign book to a reader :  method reference to constructor
        Reader reader = new Reader("Steve");
        Book bookArray[] = new Book[1];
        bookArray[0] = book;
        reader.setBookList(Arrays.asList(bookArray));
        System.out.println(reader.toString());

        //static method reference example.
        reader.getBookList().forEach(PrintBookService::print);

        //instance method reference
        reader.getBookList().forEach(reader::wrapMyBooks);

        // constructor reference: new translates to lambda expression/functional interface implementation.
        FavGenreAssigner favGenreAssigner = FavGenre::new;
        reader.setFavGenre(favGenreAssigner.assignFavGenre());

        System.out.println("Fav genre are:");
        reader.getFavGenre().getGenre().forEach(System.out::println); // again, static method ref. :)


    }
}
