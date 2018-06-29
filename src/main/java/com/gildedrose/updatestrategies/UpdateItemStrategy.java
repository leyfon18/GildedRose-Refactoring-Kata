package com.gildedrose.updatestrategies;

import com.gildedrose.Item;

public interface UpdateStrategy {
    Item apply(Item item);
}
