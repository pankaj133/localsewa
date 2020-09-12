
package com.example.localsewa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.localsewa.R;
import com.example.localsewa.adapters.SearchAdapter;
import com.example.localsewa.databinding.ActivitySearchBinding;
import com.example.localsewa.models.searchmodels.SearchMsg;
import com.example.localsewa.viewmodels.SearchViewModel;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding activitySearchBinding;
    private SearchAdapter searchAdapter;
    private RecyclerView searchrecyclerView;
    private SearchViewModel searchViewModel;

    private EditText editTextseach;
    //  private List<Msg> serachedlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        //viewmodel
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        //recyclerview
        searchrecyclerView = activitySearchBinding.searchrecyclerview;
        searchAdapter = new SearchAdapter(this);
        searchrecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        searchrecyclerView.setHasFixedSize(true);
        searchrecyclerView.setAdapter(searchAdapter);


        editTextseach = activitySearchBinding.searchview;
        //this is opening keybord when user coming from the main activity
        editTextseach.requestFocus();

        editTextseach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editTextseach.getText().toString().trim() != null) {

                    if (editTextseach.getText().toString().trim().length() >= 3) {
                        String item = editTextseach.getText().toString().trim();
                        /*Toast.makeText(SearchActivity.this, "" + item, Toast.LENGTH_SHORT).show();*/
                        filter(item);
                    }
                } else {
                    //searchAdapter.data.clear();
                    searchAdapter.Setdata(null);
                }
            }
        });
    }

    private void filter(String item) {
        searchViewModel.getsearcheddata(item).observe(this,searchMsgs -> {
            searchAdapter.Setdata(searchMsgs);
        });

        /*searchViewModel.getsearcheddata(item).observe(this, new Observer<List<SearchMsg>>() {
            @Override
            public void onChanged(List<SearchMsg> searchMsgs) {

                searchAdapter.Setdata(searchMsgs);
            }
        });*/
    }
}