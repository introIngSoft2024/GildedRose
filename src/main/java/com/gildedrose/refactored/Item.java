package com.gildedrose.refactored;

/**
 * Represents an item that can be sold in the Gilded Rose shop. Each item has a name, a sell-in
 * value, and a quality value.
 */
public class Item {

  private final String name; // The name of the item
  private int sellIn; // The number of days until the item has to be sold
  private int quality; // The quality of the item

  /**
   * Constructs a new Item with the given name, sell-in value, and quality value.
   *
   * @param name The name of the item.
   * @param sellIn The number of days until the item has to be sold.
   * @param quality The quality of the item.
   */
  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.setSellIn(sellIn);
    this.setQuality(quality);
  }

  /**
   * Returns a string representation of the item.
   *
   * @return A string containing the name, sell-in value, and quality value of the item.
   */
  @Override
  public String toString() {
    return this.getName() + ", " + this.getSellIn() + ", " + this.getQuality();
  }

  /**
   * Returns the number of days until the item has to be sold.
   *
   * @return The sell-in value of the item.
   */
  public int getSellIn() {
    return sellIn;
  }

  /**
   * Sets the number of days until the item has to be sold.
   *
   * @param sellIn The sell-in value to set.
   */
  public void setSellIn(int sellIn) {
    this.sellIn = sellIn;
  }

  /**
   * Returns the name of the item.
   *
   * @return The name of the item.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the quality of the item.
   *
   * @return The quality value of the item.
   */
  public int getQuality() {
    return quality;
  }

  /**
   * Sets the quality of the item.
   *
   * @param quality The quality value to set.
   */
  public void setQuality(int quality) {
    this.quality = quality;
  }
}
