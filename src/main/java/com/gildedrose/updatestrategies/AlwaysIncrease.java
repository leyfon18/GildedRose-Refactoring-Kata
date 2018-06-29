package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class AlwaysIncrease implements UpdateItemStrategy {
    @Override
    public Item apply(Item item) {
        return item.decrementSellIn().plusQuality(1);
    }
}
