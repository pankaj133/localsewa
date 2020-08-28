package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.localsewa.R;
import com.example.localsewa.adapters.SearchAdapter;
import com.example.localsewa.databinding.ActivitySearchBinding;
import com.example.localsewa.models.searchmodels.Msg;
import com.example.localsewa.viewmodels.SearchViewModel;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding activitySearchBinding;
    private SearchAdapter searchAdapter;
    private RecyclerView searchrecyclerView;
    private SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);


        //viewmodel
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);

        //recyclerview
        searchrecyclerView = activitySearchBinding.searchrecyclerview;
        searchAdapter = new SearchAdapter(this);
        searchrecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        searchrecyclerView.setHasFixedSize(true);
        searchrecyclerView.setAdapter(searchAdapter);

        //this is opening keybord when user coming from the main activity
        activitySearchBinding.searchview.requestFocus();

        activitySearchBinding.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.msgLiveData.clear();
                if(newText.isEmpty()){
                    searchAdapter.data(null);
                }
                searchAdapter.data(null);
                filter(newText);
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
        });
    }
























    public void filter(final String item) {
        searchViewModel.getsearcheddata(item).observe(this, new Observer<List<Msg>>() {
            @Override
            public void onChanged(List<Msg> msgs) {
            searchAdapter.data(msgs);
            }
        });
    }



}

