package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public interface UpdateItemStrategy {
    Item apply(Item item);
}
