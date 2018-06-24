package com.gildedrose.itemdeprecationstrategies;

import com.gildedrose.Item;

public class IntervalDeprecation implements ItemDeprecationStrategy {
    private int upperbound;
    private int lowerbound;

    public IntervalDeprecation(int upperbound, int lowerbound) {
        this.upperbound = upperbound;
        this.lowerbound = lowerbound;
    }

    @Override
    public Item update(Item i) {
        Item item = i.descrementSellIn();

        if (item.isExpired()) {
            return item.withZeroQuality();
        } else {
            int unit = 1;
            if (item.getSellIn() < upperbound) {
                unit += 1;
            } else if (item.getSellIn() < lowerbound) {
                unit += 1;
            }
            return item.plusQuality(unit);
        }
    }
}
