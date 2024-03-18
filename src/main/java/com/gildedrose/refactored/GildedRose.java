package com.gildedrose.refactored;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
  private static final String AGED_BRIE = "Aged Brie";
  private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  Item[] items;

  private List<String> SPECIAL_ITEMS;

  public GildedRose(Item[] items) {
    this.items = items;
    SPECIAL_ITEMS = new ArrayList<>();
    SPECIAL_ITEMS.add(SULFURAS);
    SPECIAL_ITEMS.add(BACKSTAGE_PASS);
    SPECIAL_ITEMS.add(AGED_BRIE);
  }

  public void updateQuality() {
    for (Item item : items) {
      updateQuality(item);
      updateQualityAccordingToSellIn(item);
    }
  }

  private void updateQuality(Item item) {
    if (isNotSpecial(item)) {
      decreaseQuality(item);
      decreaseSellIn(item);
      if (item.getSellIn() < 0) {
        decreaseQuality(item);
      }
    } else {
      increaseQuality(item);

      if (isBackstagePass(item)) {
        if (item.getSellIn() < 11) {
          increaseQuality(item);
        }

        if (item.getSellIn() < 6) {
          increaseQuality(item);
        }
      }
    }
  }

  private void updateQualityAccordingToSellIn(Item item) {
    if (!isSulfuras(item)) {
      decreaseSellIn(item);
    }

    if (item.getSellIn() < 0) {
       if (isBackstagePass(item)) {
        item.setQuality(0);
      } else if(isAgedBrie(item)) {
        increaseQuality(item);
      }
    }
  }

  private void decreaseSellIn(Item item) {
    item.setSellIn(item.getSellIn() - 1);
  }

  private boolean isSulfuras(Item item) {
    return item.getName().equals(SULFURAS);
  }

  private boolean isBackstagePass(Item item) {
    return item.getName().equals(BACKSTAGE_PASS);
  }

  private boolean isAgedBrie(Item item) {
    return item.getName().equals(AGED_BRIE);
  }

  private void increaseQuality(Item item) {
    if (item.getQuality() < 50) {
      item.setQuality(item.getQuality() + 1);
    }
  }

  private void decreaseQuality(Item item) {
    if (item.getQuality() > 0) {
      item.setQuality(item.getQuality() - 1);
    }
  }

  private boolean isNotSpecial(Item item) {
    return !SPECIAL_ITEMS.contains(item.getName());
  }
}
