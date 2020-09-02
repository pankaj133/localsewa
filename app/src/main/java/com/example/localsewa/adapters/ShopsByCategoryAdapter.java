package com.example.localsewa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.localsewa.R;
import com.example.localsewa.databinding.CustomLayoutForShopsbycategoryBinding;
import com.example.localsewa.models.shopsbycategorymodels.Msg;
import java.util.List;

public class ShopsByCategoryAdapter extends RecyclerView.Adapter<ShopsByCategoryAdapter.VHolder> {


    private  Context context;
    private List<Msg> rasturantDescriptions;

    public ShopsByCategoryAdapter(Context context) {
        this.context = context;
    }

    public void shopsdatabycat(List<Msg> rasturantDescriptions){
        this.rasturantDescriptions = rasturantDescriptions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomLayoutForShopsbycategoryBinding shopsbycategoryBinding
                = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.custom_layout_for_shopsbycategory,parent,false);
        return new VHolder(shopsbycategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {
        Msg rs = rasturantDescriptions.get(position);
        holder.shopsbinding.setShopsbycat(rs);

    }

    @Override
    public int getItemCount() {
        if( rasturantDescriptions == null){
            return 0;
        }
        return rasturantDescriptions.size();
    }

    public class VHolder extends RecyclerView.ViewHolder {
        CustomLayoutForShopsbycategoryBinding shopsbinding;
        public VHolder(@NonNull CustomLayoutForShopsbycategoryBinding itemView) {
            super(itemView.getRoot());
            shopsbinding = itemView;
        }
    }
}
