package com.gildedrose.itemdeprecationstrategies;

import com.gildedrose.Item;

public class AlwaysIncrese implements ItemDeprecationStrategy {
    @Override
    public Item update(Item item) {
        return item.descrementSellIn().plusQuality(1);
    }
}
