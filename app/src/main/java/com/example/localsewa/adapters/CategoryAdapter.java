package com.example.localsewa.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.localsewa.R;
import com.example.localsewa.databinding.CategoryCustomLayoutBinding;
import com.example.localsewa.models.Message;
import com.example.localsewa.views.ShopsByCategory;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder> {


    private List<Message> msgList;
    private Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void data(List<Message> msgs) {
        this.msgList = msgs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryCustomLayoutBinding categoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context),
                        R.layout.category_custom_layout, parent, false);
        return new Holder(categoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Message msg = msgList.get(position);
        holder.categoryCustomLayoutBinding.setCategory(msg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context, ShopsByCategory.class);
               intent.putExtra("cat_id",msg.getId());
               intent.putExtra("name",msg.getName());
               context.startActivity(intent);


            }
        });
    }
    @Override
    public int getItemCount() {
        if (msgList == null)
            return 0;
        else
            return msgList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private CategoryCustomLayoutBinding categoryCustomLayoutBinding;

        public Holder(@NonNull CategoryCustomLayoutBinding categoryBinding) {
            super(categoryBinding.getRoot());

            this.categoryCustomLayoutBinding = categoryBinding;
        }
    }
}
