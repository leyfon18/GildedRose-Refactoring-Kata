package com.gildedrose;

public class Item {
    private static final int MAX_QUALITY = 50;
    public static final int EXPIRED_SELL_IN = 0;

    private final String name;

    private final int sellIn;

    private final int quality;

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
        return this.sellIn < EXPIRED_SELL_IN;
    }

    public Item plusQuality(int amount) {
        return new Item(name, sellIn, getNewQuality(amount));
    }

    public Item minusQuality(int amount) {
        return new Item(name, sellIn, getNewQuality(-amount));
    }

    private int getNewQuality(int amount) {
        int newQuality = quality + amount;
        if (newQuality > MAX_QUALITY) {
            return MAX_QUALITY;
        } else {
            return newQuality;
        }
    }

<<<<<<< HEAD
    public Item minusQuality(int unit) {
        int resultQuality = this.quality - unit;
        if (resultQuality < 0) {
            resultQuality = 0;
        } else if (resultQuality > 50) {
            resultQuality = 50;
        }
        return new Item(name, sellIn, resultQuality);
    }

=======
>>>>>>> 88e8d20... Final refactor
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
