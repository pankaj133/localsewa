package com.example.localsewa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.example.localsewa.R;
import com.example.localsewa.databinding.CustomSearchItemBinding;
import com.example.localsewa.models.searchmodels.Msg;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    public List<Msg> msgLiveData = new ArrayList<>();
    private Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void data(List<Msg> msgLiveData) {
        this.msgLiveData = msgLiveData;
        notifyDataSetChanged(); }
    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomSearchItemBinding custom = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_search_item, parent, false);
        return new SearchHolder(custom); }
    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        Msg msg = msgLiveData.get(position);
        holder.customSearchItem.setSearch(msg);
    }
    @Override
    public int getItemCount() {
        if(msgLiveData == null){
            return 0;
        }
        else {
            return msgLiveData.size(); } }
    public class SearchHolder extends RecyclerView.ViewHolder {

        CustomSearchItemBinding customSearchItem;
        public SearchHolder(@NonNull CustomSearchItemBinding itemView) {
            super(itemView.getRoot());
            customSearchItem = itemView;
        }
    }
}
