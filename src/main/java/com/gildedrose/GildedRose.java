package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            item.descrementSellIn();

            if (item.name.equals("Aged Brie")) {
                item.incrementQuality();
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.isExpired()) {
                    item.quality = 0;
                } else {
                    if (item.sellIn < 11) {
                        item.incrementQuality();
                    } else if (item.sellIn < 6) {
                        item.incrementQuality();
                    } else {
                        item.incrementQuality();
                    }
                }
            } else if (item.isExpired() && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.decrementQuality();
            }
        }
    }
}