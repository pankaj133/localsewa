package com.example.localsewa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.localsewa.R;
import com.example.localsewa.databinding.BestsellerlayoutBinding;
import com.example.localsewa.databinding.CustomLayoutForAllShowsBinding;
import com.example.localsewa.databinding.CustomSearchItemBinding;
import com.example.localsewa.models.bestsellermodels.Msg;
import java.util.List;

public class AllShopsAdapter extends RecyclerView.Adapter<AllShopsAdapter.AllShopsHolder>{


    private Context context;

    private List<Msg> msgs;

    public AllShopsAdapter(Context context) {
        this.context = context;
    }

    public void bestsller(List<Msg> msgs){
        this.msgs = msgs;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AllShopsAdapter.AllShopsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomLayoutForAllShowsBinding customLayoutForAllShowsBinding
                = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.custom_layout_for_all_shows,parent,false);

        return new AllShopsHolder(customLayoutForAllShowsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllShopsAdapter.AllShopsHolder holder, int position) {
        Msg msg = msgs.get(position);
        holder.bestsellerlayoutBinding.setBest(msg);
    }

    @Override
    public int getItemCount() {
        if(msgs == null){
            return 0;
        }else{
            return msgs.size();
        }
    }

    public class AllShopsHolder extends RecyclerView.ViewHolder {

        CustomLayoutForAllShowsBinding bestsellerlayoutBinding;
        public AllShopsHolder(@NonNull CustomLayoutForAllShowsBinding itemView) {
            super(itemView.getRoot());
            bestsellerlayoutBinding = itemView;
        }
    }
}