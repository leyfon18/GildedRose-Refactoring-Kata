package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class AlwaysIncrese implements UpdateStrategy {
    @Override
    public Item apply(Item item) {
        return item.descrementSellIn().plusQuality(1);
    }
}
