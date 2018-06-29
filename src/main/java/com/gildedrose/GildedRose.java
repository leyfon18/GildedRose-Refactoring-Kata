package com.gildedrose;

import com.gildedrose.updatestrategies.*;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {
    public static final Map<String, UpdateItemStrategy> deprecationStrategiesMap;
    static {
        deprecationStrategiesMap = new HashMap<>();
        deprecationStrategiesMap.put("Aged Brie", new AlwaysIncrease());
        deprecationStrategiesMap.put("Backstage passes to a TAFKAL80ETC concert", new IncreaseQualityWithThreshold(11, 6));
        deprecationStrategiesMap.put("Sulfuras, Hand of Ragnaros", new NeverChange());
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
        UpdateItemStrategy strategy = deprecationStrategiesMap.getOrDefault(item.getName(), new AlwaysDecrease());
        return strategy.apply(item);
    }
}