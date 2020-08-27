package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
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



/*
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setIconified(false);*/





        //viewmodel
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);

        //recyclerview
        searchrecyclerView = activitySearchBinding.searchrecyclerview;
        searchAdapter = new SearchAdapter(this);
        searchrecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        searchrecyclerView.setHasFixedSize(true);
        searchrecyclerView.setAdapter(searchAdapter);





       /* activitySearchBinding.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() <= 0) {
                    searchAdapter.data(null);
                }
                else{
                    searchViewModel.getsearcheddata(newText).observe(SearchActivity.this, new Observer<List<Msg>>() {
                        @Override
                        public void onChanged(List<Msg> msgs) {
                            searchAdapter.data(msgs);
                        }
                    });
                }

                return true;
            }


        });
    }*/

}


}