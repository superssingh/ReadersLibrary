package com.santossingh.readerslibrary.Interfaces;

import com.santossingh.readerslibrary.Database.BooksLibrary;
import com.santossingh.readerslibrary.R;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by santoshsingh on 24/12/16.
 */
public interface LibraryAPI {
    //By Popularity-----------------------
//    R.string.DownloadLink
    @GET("/books/v1/volumes?q=1")
    Call<BooksLibrary> getPopBooks();

    //By TopRating------------------------
    @GET(R.string.Fantasy + "")
    Call<BooksLibrary> getTopBooks();

    //for Reviews------------------------
    @GET(R.string.BookReview + "" + R.string.KEY)
    Call<BooksLibrary> getBookReviews(@Path("id") String id);

    //For Preview------------------------
    @GET(R.string.Preview + "" + R.string.KEY)
    Call<BooksLibrary> getBookPreview(@Path("id") String id);
}
