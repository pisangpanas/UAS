package com.android.uas.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.uas.ApiClient;
import com.android.uas.ApiService;
import com.android.uas.Football;
import com.android.uas.FootballAdapter;
import com.android.uas.FootballResponse;
import com.android.uas.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FootballFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FootballFragment extends Fragment {
    private ArrayList<Football> listFootball;
    private RecyclerView rvFootball;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_football, container, false);
        rvFootball = view.findViewById(R.id.rv_football);
        rvFootball.setHasFixedSize(true);
        rvFootball.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);

        Call<FootballResponse> call = service.getSchedule("id=4328");
        call.enqueue(new Callback<FootballResponse>() {
            @Override
            public void onResponse(Call<FootballResponse> call, Response<FootballResponse> response) {

                listFootball = response.body().getEvents();

                FootballAdapter footballAdapter = new FootballAdapter(listFootball);
                rvFootball.setAdapter(footballAdapter);
            }

            @Override
            public void onFailure(Call<FootballResponse> call, Throwable t) {

            }
        });


        return view;

    }
}