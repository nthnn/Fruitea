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

package shop.nthnn.fruitea;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import shop.nthnn.fruitea.adapter.DiscountedProductAdapter;
import shop.nthnn.fruitea.adapter.ProductViewAdapter;
import shop.nthnn.fruitea.model.DiscountedProducts;
import shop.nthnn.fruitea.model.ProductView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView discountedRecyclerView, productViewRecycler;
    private List<DiscountedProducts> discountedProductsList;
    private List<ProductView> productViewList;
    private Runnable carouselNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.discountedRecyclerView = (RecyclerView) this.findViewById(R.id.main_discount_recycler);
        this.discountedProductsList =new ArrayList<>();

        this.discountedProductsList.add(new DiscountedProducts(1, R.drawable.discount_1));
        this.discountedProductsList.add(new DiscountedProducts(2, R.drawable.discount_2));
        this.discountedProductsList.add(new DiscountedProducts(3, R.drawable.discount_3));

        this.productViewRecycler = (RecyclerView) this.findViewById(R.id.main_products_recycler);
        this.productViewList = new ArrayList<>();

        this.productViewList.add(new ProductView("Ceylonic Assam", "Classic British Legacy Tea, which is a satisfying blend of strong Assam and smooth liquoring Ceylon.", 180.0f, 219.75f, 250.0f, R.drawable.product_card_1, R.drawable.product_1));
        this.productViewList.add(new ProductView("Blackgrapes", "Fresh black seedless grapes blended with Jasmin Green Tea, topped with house-made cheese foam.", 190.0f, 220.0f, 249.0f,  R.drawable.product_card_2, R.drawable.product_2));
        this.productViewList.add(new ProductView("Smoothie-berry", "Fresh strawberries blended with Jasmine Green Tea, topped with house-made cheese form.", 199.25f, 229.50f, 264.75f, R.drawable.product_card_3, R.drawable.product_3));
        this.productViewList.add(new ProductView("Doubleberry", "Fresh strawberries and blueberries blended with Jasmine Green Tea. Topped with house-made cheese form.", 180.75f, 212.25f, 249.5f, R.drawable.product_card_4, R.drawable.product_4));

        List<CarouselItem> dataList = new ArrayList<>();
        dataList.add(new CarouselItem(R.drawable.product_1, "Cecylon Assam"));
        dataList.add(new CarouselItem(R.drawable.product_2, "Blackgrapes"));
        dataList.add(new CarouselItem(R.drawable.product_3, "Smoothie-berry"));
        dataList.add(new CarouselItem(R.drawable.product_4, "Doubleberry"));

        final ImageCarousel carousel = (ImageCarousel) this.findViewById(R.id.main_carousel);
        carousel.registerLifecycle(this.getLifecycle());
        carousel.setData(dataList);
        carousel.setTopShadowAlpha(0f);
        carousel.setBottomShadowAlpha(0f);

        this.setDiscountedRecycler();
        this.setRecentlyRecycler();

        final Handler handler = new Handler();
        this.carouselNext = new Runnable() {
            @Override
            public void run() {
                carousel.next();
                handler.postDelayed(MainActivity.this.carouselNext, 3000);
            };
        };

        handler.postDelayed(this.carouselNext, 3000);
    }

    private void setRecentlyRecycler() {
        this.productViewRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.productViewRecycler.setAdapter(new ProductViewAdapter(this, this.productViewList));
    }

    private void setDiscountedRecycler() {
        this.discountedRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        this.discountedRecyclerView.setAdapter(new DiscountedProductAdapter(this, this.discountedProductsList));
    }
}