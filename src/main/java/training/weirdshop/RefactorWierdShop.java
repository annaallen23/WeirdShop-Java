package training.weirdshop;

public class RefactorWierdShop {
    private Item[] items;

    public RefactorWierdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (int i = 0; i < items.length; i++) { //iterates through length of items

            if (!items[i].name.equals("Gold Coin")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].name.equals("Aged Brie")) {
                updateAgedBrie(items[i]);
            } else if (items[i].name.equals("Gold Coin")) { //if item is gold coin
                items[i].quality = 80; //quality is always 80 no decrease in sellIn
            } else if (items[i].name.equals("Backstage Pass")) {//if items is backstage pass
                updateBackstagePass(items[i]);
            } else {
                updateOtherItem(items[i]);
            }

        }
    }

    private void updateOtherItem(Item item) {
        if (item.quality <= 0) {
            item.quality = 0;
        } else if (item.sellIn < 0) {
            item.quality = item.quality - 2;
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;

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

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {//if item is aged brie and quality <50
            item.quality = item.quality + 1; //increase quality by 1
        } else {
            item.quality = 50;
        }
    }
}
