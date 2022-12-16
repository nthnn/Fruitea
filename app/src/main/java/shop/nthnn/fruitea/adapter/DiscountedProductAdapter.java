package shop.nthnn.fruitea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import shop.nthnn.fruitea.R;
import shop.nthnn.fruitea.model.DiscountedProducts;

import java.util.List;

public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder> {
    private Context context;
    private List<DiscountedProducts> discountedProductList;

    public DiscountedProductAdapter(Context context, List<DiscountedProducts> list) {
        this.context = context;
        this.discountedProductList = list;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DiscountedProductViewHolder(LayoutInflater.from(this.context).inflate(R.layout.discounted_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {
        holder.discountedImageView.setImageResource(this.discountedProductList.get(position).getDrawableImage());
    }

    @Override
    public int getItemCount() {
        return this.discountedProductList.size();
    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder{
        public ImageView discountedImageView;

        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.discountedImageView = itemView.findViewById(R.id.discount_image);
        }
    }
}