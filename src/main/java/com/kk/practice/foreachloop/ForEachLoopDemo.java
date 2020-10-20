package com.kk.practice.foreachloop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Java collections have introduced a new way to loop, using forEach.
 * forEach takes a consumer interface (BiConsumer for Map).
 * So, it can also take an equivalent lambda function as well as input.
 * */

public class ForEachLoopDemo {

    public static void main(String[] args) {

        String newBooksTitle[] = {"HP1", "HP2", "HP3"};

        // pass a consumer in forEach
        Arrays.asList(newBooksTitle).forEach(System.out::println);

        // consumer as lambda expression
        Arrays.asList(newBooksTitle).forEach((b) -> System.out.println(b.contains("HP3")));


        Map<Integer, String> bookMap = new HashMap<>();
        bookMap.put(1, "Only Time will tell");
        bookMap.put(2, "Cliffton Chronicles");
        bookMap.put(3, "Best Kept secret");
        bookMap.put(4, "Be careful what you wish for!");

        // map's forEach accepts a BiConsumer
        bookMap.forEach((id, name) -> System.out.println("[Id:" + id + "name:" + name + "]"));

    }
}
