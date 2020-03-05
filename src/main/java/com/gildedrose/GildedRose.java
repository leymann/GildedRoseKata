package com.gildedrose;

import com.gildedrose.updaters.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GildedRose {


    Item[] items;

    static Map<String, ItemVisitorStrategy> itemsUpdaterFactory = new HashMap<>();

    static {
        itemsUpdaterFactory.put("Aged Brie", new AgedBrieItemUpdater());
        itemsUpdaterFactory.put("Sulfuras, Hand of Ragnaros", new SulfurasItemUpdater());
        itemsUpdaterFactory.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassItemUpdater());
        itemsUpdaterFactory.put("Conjured", new ConjuredItemUpdater());
    }


    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        Arrays.stream(items).forEach(this::doVisitAnItem);
    }


    private void doVisitAnItem(Item item){
        itemsUpdaterFactory.getOrDefault(item.name, new OrdinaryItemUpdater()).visit(item);
    }



    @Deprecated
    public void updateQuality0() {

            for (Item item : items) {

                if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.updateQuality(-1);
                    }
                }

            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.updateQuality(1);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.updateQuality(1);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.updateQuality(-1);
                            }
                        }
                    } else {
                        item.updateQuality(-item.quality);
                    }
                } else {
                    if (item.quality < 50) {
                        item.updateQuality(1);
                    }
                }
            }
        }
    }


}