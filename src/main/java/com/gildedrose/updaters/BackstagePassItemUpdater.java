package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassItemUpdater extends AbstractItemVisitorUpdater {


    @Override
    public Item visit(Item item) {

        int quality;

        if(isSellInPassed(item)) {
            quality = 0;
        } else if(isSellInInLessThanOrEquals(item, 6)) {
            quality = item.quality + 3;
        } else if(isSellInInLessThanOrEquals(item, 11)) {
            quality = item.quality + 2;
        } else {
            quality = item.quality + 1;
        }

        if(isItemQualityGreaterThanMaxAcceptedQuality(quality)) {
            quality = 50;
        }

        item.updateQuality(quality);

        return item;
    }


}