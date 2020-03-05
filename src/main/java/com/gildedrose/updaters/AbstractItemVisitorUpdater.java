package com.gildedrose.updaters;

import com.gildedrose.Item;

public abstract class AbstractItemVisitorUpdater implements ItemVisitorStrategy {

    private static final int MAX_QUALITY = 50;


    protected boolean isSellInPassed(Item item) {
        return item.sellIn < 1;
    }

    protected boolean isItemQualityGreaterThanMaxAcceptedQuality(int value) {
        return value > MAX_QUALITY;
    }

    protected boolean isSellInInLessThanOrEquals(Item item, int value) {
        return item.sellIn < value;
    }


    protected boolean isSellInNotYetPassed(Item item) {
        return item.sellIn > -1;
    }


    protected int resetQualityIfNegative(int quality) {

        if (isQualityNegative(quality)) {
            return 0;
        }

        return quality;
    }

    private boolean isQualityNegative(int newQuality) {
        return newQuality < 0;
    }

}
