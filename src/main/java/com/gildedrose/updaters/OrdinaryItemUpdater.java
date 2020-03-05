package com.gildedrose.updaters;

import com.gildedrose.Item;

public class OrdinaryItemUpdater extends AbstractItemVisitorUpdater {

    @Override
    public Item visit(Item item) {
        int quality = isSellInNotYetPassed(item) ? item.quality - 1 : item.quality - 2;

        quality = resetQualityIfNegative(quality);

        item.updateQuality(quality);

        return item;
    }

  }

