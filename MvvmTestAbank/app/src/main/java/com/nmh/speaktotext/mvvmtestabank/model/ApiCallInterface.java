package com.nmh.speaktotext.mvvmtestabank.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiCallInterface {

    @GET("marvel")
    Single<List<Repository>> getRepositories();
}
