package com.santossingh.readerslibrary.Interfaces;

import com.santossingh.readerslibrary.Database.BooksLibrary;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by santoshsingh on 24/12/16.
 */
public interface LibraryAPI {

    //By Popularity-----------------------

    @GET("/books/v1/volumes?q=1")
    Call<BooksLibrary> getPopBooks();

}
