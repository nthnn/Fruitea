package shop.nthnn.fruitea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    private ImageView imageViewProduct, imageViewBack;
    private TextView tvName, tvDesc, tvPrice;

    private void setPrice(float price) {
        this.tvPrice.setText("Php " + String.valueOf(price).replace(".0", ""));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_product_details);

        Intent intent = this.getIntent();
        int image = intent.getIntExtra("image", R.drawable.product_1);
        float smallPrice = intent.getFloatExtra("smallPrice", 0.0f),
            medPrice = intent.getFloatExtra("medPrice", 0.0f),
            largePrice = intent.getFloatExtra("largePrice", 0.0f);
        String name = intent.getStringExtra("name"),
            desc = intent.getStringExtra("desc");

        final Button btnSmall = (Button) this.findViewById(R.id.product_details_btn_small),
            btnMedium = (Button) this.findViewById(R.id.product_details_btn_medium),
            btnLarge = (Button) this.findViewById(R.id.product_details_btn_large);

        this.tvName = (TextView) this.findViewById(R.id.product_details_label_name);
        this.tvDesc = (TextView) this.findViewById(R.id.product_details_label_desc);
        this.tvPrice = (TextView) this.findViewById(R.id.product_details_label_price);

        this.imageViewProduct = (ImageView) this.findViewById(R.id.product_details_image);
        this.imageViewBack = (ImageView) this.findViewById(R.id.product_details_ic_back);

        this.tvName.setText(name);
        this.tvDesc.setText("\t" + desc);
        this.setPrice(smallPrice);

        this.imageViewProduct.setImageResource(image);
        this.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductDetails.this.startActivity(new Intent(ProductDetails.this,MainActivity.class));
                ProductDetails.this.finishAffinity();
            }
        });

        btnSmall.setEnabled(false);
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSmall.setEnabled(false);
                btnMedium.setEnabled(true);
                btnLarge.setEnabled(true);

                ProductDetails.this.setPrice(smallPrice);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSmall.setEnabled(true);
                btnMedium.setEnabled(false);
                btnLarge.setEnabled(true);

                ProductDetails.this.setPrice(medPrice);
            }
        });

        btnLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSmall.setEnabled(true);
                btnMedium.setEnabled(true);
                btnLarge.setEnabled(false);

                ProductDetails.this.setPrice(largePrice);
            }
        });
    }
}