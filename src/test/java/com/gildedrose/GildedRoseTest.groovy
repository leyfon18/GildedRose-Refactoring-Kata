package com.gildedrose

import org.junit.Test
import spock.lang.Specification

import static org.junit.Assert.assertEquals

class GildedRoseTest extends Specification {

    def "Foo test"(){
        setup:
        Item[] items = [new Item("foo", 0, 0)]
        GildedRose app = new GildedRose(items)
        when:
        app.updateQuality()
        then:
        "foo" == app.items[0].name
    }

    def "test fixtures"(){
        setup:
        def nDays = 1
        GildedRose app = new GildedRose([new Item(name, sellIn, quality)].toArray(new Item[0]))
        expect:
        for (int i = 0; i < nDays; i++) {
            app.updateQuality()
        }
        def item = app.items[0]
        item.sellIn == expectedSellIn
        item.quality == expectedQuality


        where:
        name | sellIn | quality | expectedSellIn | expectedQuality
        "+5 Dexterity Vest"|10|20|9|19
        "Aged Brie"|2|0|1|1
        "Elixir of the Mongoose"|5|7|4|6
        "Sulfuras, Hand of Ragnaros"|0|80|0|80
        "Sulfuras, Hand of Ragnaros"|-1|80|-1|80
        "Backstage passes to a TAFKAL80ETC concert"|15|20|14|21
        "Backstage passes to a TAFKAL80ETC concert"|10|49|9|50
        "Backstage passes to a TAFKAL80ETC concert"|5|49|4|50
        "Conjured Mana Cake"|3|6|2|5
    }

    def "Aged brie"(){
        setup:
        def nDays = 10
        GildedRose app = new GildedRose([new Item("Aged Brie", 5, 0)].toArray(new Item[0]))
        expect:
        for (int i = 0; i < nDays; i++) {
            app.updateQuality()
        }
        def item = app.items[0]
        item.quality == 10
    }

    def "Backstage passes to a TAFKAL80ETC concert quality become 0 when expire"(){
        setup:
        def nDays = 3
        GildedRose app = new GildedRose([new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)].toArray(new Item[0]))
        expect:
        for (int i = 0; i < nDays; i++) {
            app.updateQuality()
        }
        def item = app.items[0]
        item.quality == 0
    }
}
