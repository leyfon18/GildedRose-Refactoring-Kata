package com.gildedrose.itemdeprecationstrategies;

import com.gildedrose.Item;

public class NeverDeprecate implements ItemDeprecationStrategy {
    @Override
    public Item update(Item item) {
        return item;
    }
}
