package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class DefaultDeprecation implements UpdateStrategy {
    @Override
    public Item apply(Item i) {
        Item item = i.descrementSellIn();

        if (item.isExpired()) {
            return item.plusQuality(-2);
        }else{
            return item.plusQuality(-1);
        }
    }
}
