package training.weirdshop;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class RefactorWierdShop {
    private Item[] items;

    public RefactorWierdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (Item item : items) {

            if (!item.name.equals("Gold Coin") && (!item.name.equals("Premium Gold Coin"))) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.name.equals("Premium Aged Brie")) {
                updatePremiumAgedBrie(item);
            } else if (item.name.equals("Aged Brie")) {
                updateAgedBrie(item);
            } else if (item.name.equals("Gold Coin") || (item.name.equals("Premium Gold Coin"))) {
                item.quality = 80;
            } else if (item.name.equals("Premium Backstage Pass")) {
                updatePremiumBackstagePass(item);
            } else if (item.name.equals("Backstage Pass")) {
                updateBackstagePass(item);
            } else if (item.name.equals("Some other Premium item")) {
                updateOtherPremiumItem(item);
            } else {
                updateOtherItem(item);
            }
            qualityCap(item);
        }
    }

    private void qualityCap(Item item) {
        if (item.quality <= 0) {
            item.quality = 0;
        }
        if (!item.name.equals("Gold Coin") && (!item.name.equals("Premium Gold Coin")) && item.quality > 50) {
            item.quality = 50;
        }
    }

    private void updateOtherItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality - 1;

        }
    }

    private void updateOtherPremiumItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = item.quality - 4;
        } else {
            item.quality = item.quality - 2;
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn > 10) {
            item.quality = item.quality + 1;
        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 2;
        }
    }

    private void updatePremiumBackstagePass(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn > 10) {
            item.quality = item.quality + 2;
        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 6;
        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 4;
        }
    }

    private void updateAgedBrie(Item item) {
        item.quality = item.quality + 1;
    }

    private void updatePremiumAgedBrie(Item item) {
        item.quality = item.quality + 2;

    }
}
