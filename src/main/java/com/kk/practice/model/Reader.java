package com.kk.practice.model;

import com.kk.practice.lamdaexpression.FavGenreAssigner;

import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String name;
    private List<Book> bookList;
    private FavGenre favGenre;

    public Reader(String name) {
        this.name = name;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setFavGenre(FavGenre favGenre) {
        this.favGenre = favGenre;
    }

    public FavGenre getFavGenre() {
        return favGenre;
    }

    public void printAssignedBooks(){
        System.out.printf("Assigned Book="+ bookList.toString());
    }


    public void chooseFavGenre(FavGenreAssigner favGenreAssigner){
        FavGenre favGenre = favGenreAssigner.assignFavGenre();
        List<String> readerFav = new ArrayList<>();
        favGenre.getGenre().forEach(g -> { if (g.contains("bio")) {
             readerFav.add(g);
        }  });
        favGenre = new FavGenre();
        favGenre.setGenre(readerFav);

        this.setFavGenre(favGenre);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                '}';
    }

    public void wrapMyBooks(Book book) {
        System.out.println("wrapping done.");
    }
}
