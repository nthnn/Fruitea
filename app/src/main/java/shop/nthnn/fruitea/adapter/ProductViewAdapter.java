/*
	Copyright © 2022 Nathanne Isip

	Permission is hereby granted, free of charge,
	to any person obtaining a copy of this software
	and associated documentation files (the “Software”),
	to deal in the Software without restriction,
	including without limitation the rights to use, copy,
	modify, merge, publish, distribute, sublicense,
	and/or sell copies of the Software, and to permit
	persons to whom the Software is furnished to do so,
	subject to the following conditions:
	The above copyright notice and this permission notice
	shall be included in all copies or substantial portions
	of the Software.
	THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF
	ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
	TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
	PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
	THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
	DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
	CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
	CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
	IN THE SOFTWARE.
*/

package shop.nthnn.fruitea.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import shop.nthnn.fruitea.ProductDetails;
import shop.nthnn.fruitea.R;
import shop.nthnn.fruitea.model.ProductView;

import java.util.List;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder> {
    private Context context;
    private List<ProductView> productViewList;

    public ProductViewAdapter(Context context, List<ProductView> productViewList) {
        this.context = context;
        this.productViewList = productViewList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(this.context).inflate(R.layout.product_view_items, parent, false));
    }


    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        final ProductView details = this.productViewList.get(position);

        holder.name.setText(details.getName());
        holder.description.setText(details.getDescription().split("\\. ")[0]);
        holder.price.setText("Php " + String.valueOf(details.getSmallPrice()).replace(".0", "") + "-" + String.valueOf(details.getLargePrice()).replace(".0", ""));
        holder.imageView.setImageResource(this.productViewList.get(position).getDrawableImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, ProductDetails.class);
                i.putExtra("name", details.getName());
                i.putExtra("desc", details.getDescription());
                i.putExtra("image", details.getDrawableBackgroundImage());
                i.putExtra("smallPrice", details.getSmallPrice());
                i.putExtra("medPrice", details.getMediumPrice());
                i.putExtra("largePrice", details.getLargePrice());

                ProductViewAdapter.this.context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.productViewList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;
        public ImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.recently_viewed_label_product_name);
            this.description = itemView.findViewById(R.id.recently_viewed_label_desc);
            this.price = itemView.findViewById(R.id.recently_label_price);
            this.imageView = itemView.findViewById(R.id.recently_viewed_image);
        }
    }
}