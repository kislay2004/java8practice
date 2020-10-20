package com.kk.practice.model;

import java.util.ArrayList;
import java.util.List;

public class FavGenre {


    List<String> genre;

    public FavGenre(){

        setDefaultGenre();

    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    private void setDefaultGenre(){
        genre = new ArrayList<>();
        genre.add("Fiction");
        genre.add("Biography");
    }
}
