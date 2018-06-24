package com.gildedrose;

import com.gildedrose.itemdeprecationstrategies.*;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {
    public static final Map<String, ItemDeprecationStrategy> deprecationStrategiesMap;
    static {
        deprecationStrategiesMap = new HashMap<>();
        deprecationStrategiesMap.put("Aged Brie", new AlwaysIncrese());
        deprecationStrategiesMap.put("Backstage passes to a TAFKAL80ETC concert", new IntervalDeprecation(11, 6));
        deprecationStrategiesMap.put("Sulfuras, Hand of Ragnaros", new NeverDeprecate());
    }
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = getUpdatedItem(items[i]);
            items[i] = item;
        }
    }

    private Item getUpdatedItem(Item item) {
        ItemDeprecationStrategy strategy = deprecationStrategiesMap.getOrDefault(item.getName(), new DefaultDeprecation());
        return strategy.update(item);
    }
}