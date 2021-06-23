package com.turvo.portfolio.management.resources.java.com.turvo.portfolio.management;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestSample {
    static Integer width = 100;


    public static void main(String[] args) {

        Map<String, Map<String, Integer>> author = new HashMap<>();

        Map<String, Integer> book = new HashMap<String, Integer>();
        book.put("abc", 10);
        book.put("xyz", 15);
        Map<String, Integer> book1 = new HashMap<String, Integer>();
        book.put("abc1", 5);


        author.put("author1", book);
        author.put("author2", book1);

        Map<String, Integer> bookSh = new HashMap<String, Integer>();
//
//        Map<String, Integer> val = author.get("author1");
//        bookSh.put(val);

        Integer bookWidth = 0;
        for(int i=0;i<bookSh.size();i++){
            bookWidth = bookWidth+bookSh.get(i);
        }
        while(bookWidth< width){
            Map<String, Integer> minAuthor  = getMinAuthorBooksDetails(author);
            insertIntoBookShelf(minAuthor,bookSh);
            bookWidth = calculateBookWidth(bookSh);
            author.remove(minAuthor);
        }

    }

    private static Integer calculateBookWidth(Map<String, Integer> bookSh) {
        Integer bookWidth = 0;
        for(int i=0;i<bookSh.size();i++){
            bookWidth = bookWidth+bookSh.get(i);
        }
        return bookWidth;
    }

    private static void insertIntoBookShelf(Map<String, Integer> minAuthor, Map<String, Integer> bookSh) {

        Integer bookWidth = calculateBookWidth(bookSh);
        Integer authorBookWidth = calculateBookWidth(minAuthor);
        for(int i =0;i<minAuthor.size();i++){

            if(bookWidth < width && (width-bookWidth) >= authorBookWidth){
                Set<Map.Entry<String, Integer>> insertVal= minAuthor.entrySet();
                bookSh.put(insertVal.stream().iterator().next().getKey(),minAuthor.get(i));
                bookWidth = bookWidth +minAuthor.get(i);
            }
        }
    }

    private static Map<String, Integer> getMinAuthorBooksDetails(Map<String, Map<String, Integer>> author) {
        Integer min = Integer.MAX_VALUE;
        Integer width = Integer.MAX_VALUE;
        Map<String, Integer> res = null;
        Set<Map.Entry<String, Map<String, Integer>>> val = author.entrySet();
        while(val.stream().iterator().hasNext()){
            Map<String, Integer> books= val.stream().iterator().next().getValue();
            Collection<Integer> keys= books.values();
            //
            Integer bookWidth = calculateBookWidth(books);
           if(width > bookWidth){
             //  min = keys.size();
               width = bookWidth;
               res = books;

           }
        }
        return res;
    }
}
