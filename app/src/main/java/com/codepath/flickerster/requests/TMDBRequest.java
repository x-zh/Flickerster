package com.codepath.flickerster.requests;

import com.codepath.flickerster.models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * Created by charlie_zhou on 5/22/16.
 */
public class TMDBRequest {
    static String APIKey = "a07e22bc18f5cb106bfe4cc1f83ad8ed";
    static String Host = "https://api.themoviedb.org";
    static AsyncHttpClient  client = new AsyncHttpClient();

    public static RequestHandle getMovies(ResponseHandlerInterface responseHandler) {
        String url = String.format("%s/3/movie/now_playing?api_key=%s", Host, APIKey);
        return client.get(null, url, null, responseHandler);
    }

    public static RequestHandle getTrailer(Movie movie, ResponseHandlerInterface responseHandler) {
        String url = String.format("%s/3/movie/%d/videos?api_key=%s", Host, movie.getId(), APIKey);
        return client.get(null, url, null, responseHandler);
    }
}
