package com.gildedrose;

public class Item {
    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public boolean isExpired() {
        return this.sellIn < 0;
    }

    public Item plusQuality(int unit) {
        int resultQuality = this.quality + unit;
        if (resultQuality < 0) {
            resultQuality = 0;
        } else if (resultQuality > 50) {
            resultQuality = 50;
        }
        return new Item(name, sellIn, resultQuality);
    }

    public Item minusQuality(int unit) {
        int resultQuality = this.quality - unit;
        if (resultQuality < 0) {
            resultQuality = 0;
        } else if (resultQuality > 50) {
            resultQuality = 50;
        }
        return new Item(name, sellIn, resultQuality);
    }

    public Item decrementSellIn() {
        return new Item(name, sellIn - 1, quality);
    }

    public Item withZeroQuality() {
        return new Item(name, sellIn, 0);
    }


    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
