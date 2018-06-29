package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class IncreaseQualityWithThreshold implements UpdateItemStrategy {
    public static final int FIRST_LEVEL_QUALITY_INCREASE = 2;
    public static final int SECOND_LEVEL_QUALITY_INCREASE = 3;
    public static final int DEFAULT_INCREASE = 1;
    private int firstLevel;
    private int secondLevel;

    public IncreaseQualityWithThreshold(int firstLevel, int secondLevel) {
        this.firstLevel = firstLevel;
        this.secondLevel = secondLevel;
    }

    @Override
    public Item apply(Item i) {
        Item item = i.decrementSellIn();

        if (item.isExpired()) {
            return item.withZeroQuality();
        } else {
            if (item.getSellIn() < firstLevel) {
                return item.plusQuality(FIRST_LEVEL_QUALITY_INCREASE);
            } else if (item.getSellIn() < secondLevel) {
                return item.plusQuality(SECOND_LEVEL_QUALITY_INCREASE);
            }
            return item.plusQuality(DEFAULT_INCREASE);
        }
    }
}
