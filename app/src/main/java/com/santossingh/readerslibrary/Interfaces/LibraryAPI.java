package com.santossingh.readerslibrary.Interfaces;

import com.santossingh.readerslibrary.Database.BooksLibrary;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by santoshsingh on 24/12/16.
 */
public interface LibraryAPI {
    String free = "https://www.googleapis.com/books/v1/volumes?q=1&filter=free-ebooks";

    //Free Books
    @GET("/books/v1/volumes?q=history&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeHistoryBooks();

    @GET("/books/v1/volumes?q=science&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeSciBooks();
    @GET("/books/v1/volumes?q=Geography&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeGeoBooks();
    @GET("/books/v1/volumes?q=english&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeEngBooks();
    @GET("/books/v1/volumes?q=mathmatics&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeMathBooks();
    @GET("/books/v1/volumes?q=sports&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeSportsBooks();
    @GET("/books/v1/volumes?q=business&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeBusinessBooks();
    @GET("/books/v1/volumes?q=Top&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeTopBooks();
    @GET("/books/v1/volumes?q=romance&filter=free-ebooks&maxResults=40")
    Call<BooksLibrary> getFreeRomanceBooks();

    //Paid Books
    @GET("/books/v1/volumes?q=history&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidHistoryBooks();
    @GET("/books/v1/volumes?q=science&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidSciBooks();
    @GET("/books/v1/volumes?q=Geography&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidGeoBooks();
    @GET("/books/v1/volumes?q=english&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidEngBooks();
    @GET("/books/v1/volumes?q=mathmatics&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidMathBooks();
    @GET("/books/v1/volumes?q=sports&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidSportsBooks();
    @GET("/books/v1/volumes?q=business&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidBusinessBooks();

    @GET("/books/v1/volumes?q=Top&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidTopBooks();

    @GET("/books/v1/volumes?q=romance&filter=paid-ebooks&maxResults=40")
    Call<BooksLibrary> getPaidRomanceBooks();
}
