package com.example.localsewa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.localsewa.R;
import com.example.localsewa.databinding.CustomSearchItemBinding;
import com.example.localsewa.models.searchmodels.SearchMsg;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    public List<SearchMsg> data = new ArrayList<>();
    private Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void Setdata(List<SearchMsg> msgLiveData) {
        if(msgLiveData == null){
            clear();
        }
        this.data = msgLiveData;
        notifyDataSetChanged(); }
    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomSearchItemBinding custom = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_search_item, parent, false);
        return new SearchHolder(custom);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        SearchMsg msg = data.get(position);
        holder.customSearchItem.setSearch(msg);
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }

    public class SearchHolder extends RecyclerView.ViewHolder {

        CustomSearchItemBinding customSearchItem;

        public SearchHolder(@NonNull CustomSearchItemBinding itemView) {
            super(itemView.getRoot());
            customSearchItem = itemView;
        }
    }
    private void clear() {
        this.data.clear();
    }
}
