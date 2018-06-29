package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class AlwaysDecrease implements UpdateItemStrategy {

    public static final int DECREASED_QUALITY_AFTER_EXPIRED = 2;
    public static final int DEFAULT_QUALITY = 1;

    @Override
    public Item apply(Item i) {
        Item item = i.decrementSellIn();

        if (item.isExpired()) {
            return item.minusQuality(DECREASED_QUALITY_AFTER_EXPIRED);
        }else{
            return item.minusQuality(DEFAULT_QUALITY);
        }
    }
}
