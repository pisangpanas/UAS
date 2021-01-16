package com.android.uas;

import  com.android.uas.FootballResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("eventsnextleague.php?")
    Call<FootballResponse> getSchedule(@Query("id")String id);
}
