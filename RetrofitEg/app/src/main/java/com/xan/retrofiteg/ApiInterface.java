package com.xan.retrofiteg;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {
    // API's endpoints
    @GET("/retrofit/getuser.php")
    public void getUsersList(
            Callback<List<UserListResponse>> callback);
}
