package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public class NeverChange implements UpdateItemStrategy {
    @Override
    public Item apply(Item item) {
        return item;
    }
}