package com.santossingh.readerslibrary.Interfaces;

import com.santossingh.readerslibrary.Database.BooksLibrary;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by santoshsingh on 24/12/16.
 */
public interface LibraryAPI {

    //By Popularity-----------------------

    String epub = " https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&download=epub&key=";
    String free = "https://www.googleapis.com/books/v1/volumes?q=flowers&filter=free-ebooks&key=";

    //String query= Integer.toString(R.string.Adventure);
    @GET("/books/v1/volumes?q=2&maxResults=20")
    Call<BooksLibrary> getPopBooks();
}
