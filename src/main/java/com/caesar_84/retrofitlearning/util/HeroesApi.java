package com.caesar_84.retrofitlearning.util;

import com.caesar_84.retrofitlearning.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Gabe on 9/13/18.
 */

public interface HeroesApi {
    String BASE_URL = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getAll();
}
