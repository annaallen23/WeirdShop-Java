package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (int i = 0; i < items.length; i++) { //iterates through length of items
            if (!items[i].name.equals("Aged Brie") //if item name is not Aged Brie
                    && !items[i].name.equals("Backstage Pass")) { //and item name is not Backstage Pass
                if (items[i].quality > 0) { //if the quality of item is greater than 0
                    if (!items[i].name.equals("Gold Coin")) { //it item name is not Gold Coin
                        items[i].quality = items[i].quality - 1; //decrease the items quality by 1 for each iteration if its not brie
                                                                    //pass or coin.
                    }
                }
            } else { //if item is aged brie or pass or coin goes into below:
                if (items[i].quality < 50) { //if quality of item is less than 50
                    items[i].quality = items[i].quality + 1; //increase quality by 1 for each iteration

                    if (items[i].name.equals("Backstage Pass")) { //if item name is equal to Backstage pass
                        if (items[i].sellIn < 12) { // days left to sell is less than 12
                            if (items[i].quality < 50) { // item quality is less than 50
                                items[i].quality = items[i].quality + 1; //increase quality by 1 for each iteration and +1 from original if
                            }
                        }

                        if (items[i].sellIn < 7) { //still Backstage pass if days left to sell is less than 7
                            if (items[i].quality < 50) { //quality is less than 50
                                items[i].quality = items[i].quality + 1; //increase quality by 1, +1, +1 from previous 2 ifs
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Gold Coin")) { //if item does not equal gold coin
                items[i].sellIn = items[i].sellIn - 1; //decrease sell days by 1
            }

            if (items[i].sellIn < 0) { //if item sell by date has passed
                if (!items[i].name.equals("Aged Brie")) { //if item name is not brie
                    if (!items[i].name.equals("Backstage Pass")) { //if item name is not pass
                        if (items[i].quality > 0) { //is item quality is greater than 0
                            if (!items[i].name.equals("Gold Coin")) { // if item name is not coin
                                items[i].quality = items[i].quality - 1; //decrease quality by 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;// item quality equals 0
                    }
                } else {
                    if (items[i].quality < 50) {//if item quality is less than 50
                        items[i].quality = items[i].quality + 1; //increase quality by 1
                    }
                }
            }
        }
    }
}