package com.gildedrose.itemdeprecationstrategies;

import com.gildedrose.Item;

public class DefaultDeprecation implements ItemDeprecationStrategy{
    @Override
    public Item update(Item i) {
        Item item = i.descrementSellIn();

        if (item.isExpired()) {
            return item.plusQuality(-2);
        }else{
            return item.plusQuality(-1);
        }
    }
}
