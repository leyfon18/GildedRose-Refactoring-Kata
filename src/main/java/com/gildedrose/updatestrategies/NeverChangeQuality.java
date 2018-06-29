package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class NeverChangeQuality implements UpdateItemStrategy {
    @Override
    public Item apply(Item item) {
        return item;
    }
}
