package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) { //iterates through length of items
            if (isAgedBrie(item) //if item name is not Aged Brie
                    && !isBackstagePass(item)) { //and item name is not Backstage Pass
                if (item.quality > 0) { //if the quality of item is greater than 0
                    if (!isGoldCoin(item)) { //it item name is not Gold Coin
                        item.quality = item.quality - 1; //decrease the items quality by 1 for each iteration if its not brie
                        //pass or coin.
                    }
                }
            } else {
        if (item.quality < 50) { //if quality of item is less than 50
                item.quality = item.quality + 1; //increase quality by 1 for each iteration

            if (isBackstagePass(item)) { //if item name is equal to Backstage pass
                if (item.sellIn < 12) { // days left to sell is less than 12
                    if (item.quality < 50) { // item quality is less than 50
                        item.quality = item.quality + 1; //increase quality by 1 for each iteration and +1 from original if
                    }
                }

                if (item.sellIn < 7) { //still Backstage pass if days left to sell is less than 7
                    if (item.quality < 50) { //quality is less than 50
                        item.quality = item.quality + 1; //increase quality by 1, +1, +1 from previous 2 ifs
                    }
                }
            }
        }
    }

            if (!isGoldCoin(item)) { //if item does not equal gold coin
                item.sellIn = item.sellIn - 1; //decrease sell days by 1
            }

            if (item.sellIn < 0) { //if item sell by date has passed
                if (isAgedBrie(item)) { //if item name is not brie
                    if (!isBackstagePass(item)) { //if item name is not pass
                        if (item.quality > 0) { //is item quality is greater than 0
                            if (!isGoldCoin(item)) { // if item name is not coin
                                item.quality = item.quality - 1; //decrease quality by 1
                            }
                        }
                    } else {
                        item.quality = 0;// item quality equals 0
                    }
                } else if (item.quality < 50) {//if item quality is less than 50
                    item.quality = item.quality + 1; //increase quality by 1
                }
            }
        }
    }

    private boolean isGoldCoin(Item item) {
        return item.name.equals("Gold Coin");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage Pass");
    }

    private boolean isAgedBrie(Item item) {
        return !item.name.equals("Aged Brie");
    }
}