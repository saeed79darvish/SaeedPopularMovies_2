package com.example.saeed.saeedpopularmovies_2.REST;

import com.example.saeed.saeedpopularmovies_2.Models.MovieResponse;
import com.example.saeed.saeedpopularmovies_2.Models.ReviewResponse;
import com.example.saeed.saeedpopularmovies_2.Models.TrailerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface APIService {
    String BASE_URL = "http://api.themoviedb.org/3/";
    String API_KEY = "db201c49d395bcef0e9913baa8dcbd56";
    String IMAGE_URL = "http://image.tmdb.org/t/p/w185/";

    @GET("movie/{sort}")
    Call<MovieResponse> getMoviesData(@Path("sort") String sort, @Query("api_key") String apiKey);

    @GET("movie/{id}/reviews")
    Call<ReviewResponse> getMovieReviews(@Path("id") String movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<TrailerResponse> getMovieTrailers(@Path("id") String movieId, @Query("api_key") String apiKey);


}
