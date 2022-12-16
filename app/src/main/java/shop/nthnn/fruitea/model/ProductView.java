package shop.nthnn.fruitea.model;

import androidx.annotation.DrawableRes;

public class ProductView {
    private String name, description;
    private float smallPrice, medPrice, largePrice;
    private @DrawableRes int image, backgroundImage;

    public ProductView(String name, String description, float smallPrice, float medPrice, float largePrice, @DrawableRes int image, @DrawableRes int backgroundImage) {
        this.name = name;
        this.description = description;
        this.smallPrice = smallPrice;
        this.medPrice = medPrice;
        this.largePrice = largePrice;
        this.image = image;
        this.backgroundImage = backgroundImage;
    }

    @DrawableRes
    public int getDrawableBackgroundImage() {
        return this.backgroundImage;
    }

    @DrawableRes
    public int getDrawableImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public float getSmallPrice() {
        return this.smallPrice;
    }

    public float getMediumPrice() {
        return this.medPrice;
    }

    public float getLargePrice() {
        return this.largePrice;
    }
}