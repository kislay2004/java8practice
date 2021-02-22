package com.kk.practice.stringjoiner;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerDemo {

    public static final String SINGLE_QUOTE = "'";
    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("RED", "GREEN", "BLUE");
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);

        stringList.forEach(element -> stringJoiner.add(element));

        //Use case: simple string joining, printable format in a box []
        System.out.println(stringJoiner.toString());

        //Use case: Get a formated SQL String, that can be used to build IN params in a SQL Query.
        System.out.println(getFormattedSQLQueryString(stringList));

        //Use case: to build a complete SQL query
        System.out.println(buildSqlQuery(stringList, "SELECT * FROM BOOKS WHERE JACKET_COLOR IN ( ", " )"));
        //Lets try to use it in a group by SQL query.
        System.out.println(buildSqlQuery(stringList, "SELECT jacket_color, count FROM BOOKS WHERE JACKET_COLOR IN ( ", " ) group by jacket_color"));

        //Use case: to merge to string sources.
        StringJoiner someOtherColors = new StringJoiner(DELIMITER);
        someOtherColors.add("ORANGE");
        someOtherColors.add("PURPLE");

        System.out.println("Merged list:"+ stringJoiner.merge(someOtherColors));

        System.out.println("Length (String length, not the items int list) of list now is :"+ stringJoiner.length());

    }

   /* A StringJoiner may be employed to create formatted output from a java.util.stream.Stream
    *  using java.util.stream.Collectors.joining(CharSequence)
    */
    private static String getFormattedSQLQueryString(List<String> queryParams) {

        String formattedQueryParams = queryParams.stream()
                .map(param -> SINGLE_QUOTE + param + SINGLE_QUOTE)
                .collect(Collectors.joining(DELIMITER));

        return formattedQueryParams;
    }

    // Collectors.join has other variant that takes Prefix and Suffix as input.
    private static String buildSqlQuery(List<String> queryParams, String prefix, String suffix) {

        String formattedQueryParams = queryParams.stream()
                .map(param -> SINGLE_QUOTE + param + SINGLE_QUOTE)
                .collect(Collectors.joining(DELIMITER, prefix, suffix));

        return formattedQueryParams;
    }

}
