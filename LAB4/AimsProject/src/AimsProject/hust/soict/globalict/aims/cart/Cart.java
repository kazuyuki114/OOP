package AimsProject.hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.store.Store;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Define the maxinum items a user can order
    private final ArrayList<Media> itemOrdered = new ArrayList<>(); // Array of discs

    public void addMedia(Media item, Store store) {
        if (store.itemsInStore.contains(item)) {
            if (itemOrdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("***The cart is almost full***");
            } else {
                if (!this.itemOrdered.contains(item)) {
                    itemOrdered.add(item);
                    System.out.println("***The disc has been added***");
                } else {
                    System.out.println("***The given item exists in the cart***");
                }
            }
        } else {
            System.out.println("***The given disc is unavailable***");
        }
    }

    public void removeMedia(Media item) {
        if (!this.itemOrdered.isEmpty()){
           if (this.itemOrdered.contains(item)){
                this.itemOrdered.remove(item);
                System.out.println("***The given item has benn removed from the cart***");
           } else {
               System.out.println("***The given item does not exist in the cart***");
           }
        } else {
            System.out.println("***The cart is empty***");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media item : itemOrdered) {
            if (item != null) {
                totalCost += item.getCost();
            }
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("***********************************Cart***********************************");
        System.out.println("Ordered Items:");
        for (Media item : itemOrdered) {
            System.out.println(item.toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**************************************************************************");
    }

    public Media searchID(int id) {
        for (Media m : itemOrdered){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public Media searchTitle(String title) {
        for (Media item : itemOrdered) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null;
    }
    public void sortByTitle(){
        Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCost(){
        Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public void clearItems(){
        this.itemOrdered.clear();
    }
    public int getSize(){
        return this.itemOrdered.size();
    }
}

