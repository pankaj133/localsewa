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
        BestsellerlayoutBinding bestsellerlayoutBinding
                = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.bestsellerlayout,parent,false);

        return new AllShopsHolder(bestsellerlayoutBinding);
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

        BestsellerlayoutBinding bestsellerlayoutBinding;
        public AllShopsHolder(@NonNull BestsellerlayoutBinding itemView) {
            super(itemView.getRoot());
            bestsellerlayoutBinding = itemView;
        }
    }
}