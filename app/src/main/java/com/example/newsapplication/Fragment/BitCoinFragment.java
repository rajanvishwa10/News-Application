package com.example.newsapplication.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.newsapplication.Client;
import com.example.newsapplication.MainActivity;
import com.example.newsapplication.NewsAdapter;
import com.example.newsapplication.R;
import com.example.newsapplication.parameter.Articles;
import com.example.newsapplication.parameter.Headlines;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BitCoinFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView.LayoutManager layoutManager;
    NewsAdapter newsAdapter;
    View view;
    final String API_KEY = "ae7f3c29265f4d3c8b0039def161b648";
    List<Articles> articles = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BitCoinFragment() {
        // Required empty public constructor
    }

    public static com.example.newsapplication.Fragment.BitCoinFragment newInstance(String param1, String param2) {
        com.example.newsapplication.Fragment.BitCoinFragment fragment = new com.example.newsapplication.Fragment.BitCoinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bit_coin, container, false);
        recyclerView = view.findViewById(R.id.recyclerview2);

        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        OverScrollDecoratorHelper.setUpOverScroll(recyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dt = new Date();
        String string = formatter.format(dt);
        String[] parts = string.split(" ");
        final String date = parts[0]; // 004
        final String q = "bitcoin";
        final String sort = "publishedAt";
        fetchJSON(q, date, sort, API_KEY);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                articles.clear();
                newsAdapter.notifyDataSetChanged();
                fetchJSON(q, date, sort, API_KEY);
            }
        });
        return view;
    }

    public void fetchJSON(String q, String date, String sort, String api_key) {
        Call<Headlines> call = Client.getInstance().getApi2().geteverything(q, date , sort, api_key);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null) {
                    articles.clear();
                    articles = response.body().getArticles();
                    newsAdapter = new NewsAdapter(getContext(), articles);
                    recyclerView.setAdapter(newsAdapter);
                    swipeRefreshLayout.setRefreshing(false);
                }
            }


            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                ProgressDialog progressDialog;
                progressDialog = new ProgressDialog(getContext());
                progressDialog.setTitle("Checking Internet...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("No Internet !!!");
                progressDialog.show();
            }
        });
    }

}


