package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    public void agedBrieItem_Should_Increase_Quality() {
        Item[] items = new Item[] { new Item("Aged Brie",  1, 4) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void agedBrieItem_Quality_Should_Be_positive() {
        Item[] items = new Item[] {new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }


    @Test
    public void elixirOfTheMongooseItem_Quality_Should_Be_positive() {
        Item[] items = new Item[] {new  Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }

    @Test
    public void sulfuras_Hand_of_Ragnaro_Item_Quality_Should_Be_positive() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }

    @Test
    public void sulfuras_Hand_of_Ragnaro_Item_Quality_Should_Be_positive2() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }

    @Test
    public void backstagePassesToATAFKAL80ETCConcertItem_Quality_Should_Be_positive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }

    @Test
    public void backstagePassesToATAFKAL80ETCConcertItem_Quality_Should_Be_positive2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }

    @Test
    public void backstagePassesToATAFKAL80ETCConcertItem_Quality_Should_Be_positive3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality>0);
    }


    @Test
    public void agedBrieItem_Quality_Should_Never_Exceeed_50_0() {
        Item[] items = new Item[] {new Item("Aged Brie", 2, 26) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        System.out.println(app.items[0].quality);

        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    public void agedBrieItem_Quality_Should_Never_Exceeed_50_1() {
        Item[] items = new Item[] {new Item("Aged Brie", 2, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        System.out.println(app.items[0].quality);

        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    public void agedBrieItem_Quality_Should_Never_Exceeed_50_2() {
        Item[] items = new Item[] {new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        System.out.println(app.items[0].quality);

        assertTrue(app.items[0].quality <= 50);
    }


    @Test
    public void agedBrieItem_Quality_SHould_Be_Increased_twice_if_Sell_In_Less_than_0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 30) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        System.out.println(app.items[0].quality);


        assertEquals(32, app.items[0].quality);
    }



    @Test
    public void sulfuras_Hand_of_Ragnaro_Item_Should_Never_Expire() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 4) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void sulfuras_Hand_of_Ragnaro_Item_Should_Never_Decreasee_In_Quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 4) };
        GildedRose app = new GildedRose(items);

        //System.out.println(app.items[0]);
        app.updateQuality();
        //System.out.println(app.items[0]);

        assertEquals(4, app.items[0].quality);
    }




    //TODO @Aymen
    //SHOULD IMPLEMENT UNIT TEST FOR BELOW SPECIFICATIONS
    // "Backstage passes", comme le "Aged Brie", augmente sa qualité (quality) plus le temps passe (sellIn)
    // ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours
    // ou moins, mais la qualité tombe à 0 après le concert.



}
