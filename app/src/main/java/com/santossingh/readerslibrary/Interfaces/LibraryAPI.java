package com.santossingh.readerslibrary.Interfaces;

import com.santossingh.readerslibrary.Database.BooksLibrary;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by santoshsingh on 24/12/16.
 */
public interface LibraryAPI {
    String free = "https://www.googleapis.com/books/v1/volumes?q=1&filter=free-ebooks";

    //"history&filter=free-ebooks"
    @GET("/books/v1/volumes?q=history&filter=free-ebooks")
    Call<BooksLibrary> getPopBooks();
}
