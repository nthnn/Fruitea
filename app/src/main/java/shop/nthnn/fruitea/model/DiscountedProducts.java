package shop.nthnn.fruitea.model;

import androidx.annotation.DrawableRes;

public class DiscountedProducts {
    private Integer id;
    private @DrawableRes int image;

    public DiscountedProducts(Integer id, @DrawableRes int image) {
        this.id = id;
        this.image = image;
    }

    @DrawableRes
    public int getDrawableImage() {
        return this.image;
    }
}