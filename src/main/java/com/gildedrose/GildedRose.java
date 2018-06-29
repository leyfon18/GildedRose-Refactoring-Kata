package com.gildedrose;

import com.gildedrose.updatestrategies.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GildedRose {
<<<<<<< HEAD
    public static final Map<String, UpdateItemStrategy> deprecationStrategiesMap;
    static {
        deprecationStrategiesMap = new HashMap<>();
        deprecationStrategiesMap.put("Aged Brie", new AlwaysIncrease());
        deprecationStrategiesMap.put("Backstage passes to a TAFKAL80ETC concert", new IncreaseQualityWithThreshold(11, 6));
        deprecationStrategiesMap.put("Sulfuras, Hand of Ragnaros", new NeverChange());
=======
    public static final Map<String, UpdateItemStrategy> UPDATE_STRATEGY_PROVIDER;

    public static final int FIRST_LEVEL = 11;

    public static final int SECOND_LEVEL = 6;

    static {
        UPDATE_STRATEGY_PROVIDER = new HashMap<>();
        UPDATE_STRATEGY_PROVIDER.put("Aged Brie", new QualityIncrese());
<<<<<<< HEAD
        UPDATE_STRATEGY_PROVIDER.put("Backstage passes to a TAFKAL80ETC concert", new IncreaseQualityWithThreshold(11, 6));
        UPDATE_STRATEGY_PROVIDER.put("Sulfuras, Hand of Ragnaros", new NeverChange());
>>>>>>> 88e8d20... Final refactor
=======
        UPDATE_STRATEGY_PROVIDER.put("Cheese", new QualityIncrese());
        UPDATE_STRATEGY_PROVIDER.put("Backstage passes to a TAFKAL80ETC concert",
                new IncreaseQualityWithThreshold(FIRST_LEVEL, SECOND_LEVEL));
        UPDATE_STRATEGY_PROVIDER.put("Sulfuras, Hand of Ragnaros", new NeverChangeQuality());
>>>>>>> c7bb45b... Commit
    }

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<Item> updatedItems = new ArrayList<>();
        for(Item item: items){
            UpdateItemStrategy strategy = getStrategy(item.getName());
            Item updated = strategy.apply(item);
            updatedItems.add(updated);
        }
        items = updatedItems.toArray(new Item[0]);
    }

<<<<<<< HEAD
    private Item getUpdatedItem(Item item) {
        UpdateItemStrategy strategy = deprecationStrategiesMap.getOrDefault(item.getName(), new AlwaysDecrease());
        return strategy.apply(item);
=======
    private UpdateItemStrategy getStrategy(String itemName) {
        return UPDATE_STRATEGY_PROVIDER.getOrDefault(itemName, new QualityDecrease());
>>>>>>> 88e8d20... Final refactor
    }
}