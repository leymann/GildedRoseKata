package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends AbstractItemVisitorUpdater
{
    @Override
    public Item visit(Item item) {

        int quality = isSellInNotYetPassed(item) ? item.quality -2 : item.quality -4;

        quality = resetQualityIfNegative(quality);

        item.updateQuality(quality);

        return item;
    }

  }