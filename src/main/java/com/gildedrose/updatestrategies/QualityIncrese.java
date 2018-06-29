package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class QualityIncrese implements UpdateItemStrategy {
    @Override
    public Item apply(Item item) {
        return item.decrementSellIn().plusQuality(1);
    }
}
