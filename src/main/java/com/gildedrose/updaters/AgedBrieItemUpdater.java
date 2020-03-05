package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieItemUpdater extends AbstractItemVisitorUpdater {

    @Override
    public Item visit(Item item) {

        int quality = isSellInPassed(item) ? item.quality + 2 : item.quality + 1;

        if (isItemQualityGreaterThanMaxAcceptedQuality(quality)) {
            quality = 50;
        }
        item.updateQuality(quality);
        return item;
    }

}
