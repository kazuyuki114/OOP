package AimsProject.hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import AimsProject.hust.soict.globalict.aims.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Define the maxinum items a user can order
    private ArrayList<DigitalVideoDisc> itemOrdered = new ArrayList<>(); // Array of discs

    public void addDigitalVideoDisc(DigitalVideoDisc disc, Store store) {
        if (store.itemsInStore.contains(disc)) {
            if (itemOrdered.size() == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            } else {
                itemOrdered.add(disc);
                System.out.println("The disc has been added");
            }
        } else {
            System.out.println("The given disc is invalid");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc != null) {
            if (!itemOrdered.isEmpty()) {
                if (itemOrdered.contains(disc)) {
                    itemOrdered.remove(disc);
                    System.out.println("The disc has been removed");
                } else {
                    System.out.println("The disc does not exist in the cart");
                }
            } else {
                System.out.println("The cart is empty!");
            }
        } else {
            System.out.println("The given disc is invalid");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (int i = 0; i < itemOrdered.size(); i++) {
            if (itemOrdered.get(i) != null) {
                totalCost += itemOrdered.get(i).getCost();
            }
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("***********************************Cart***********************************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemOrdered.size(); i++) {
            System.out.println(itemOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**************************************************************************");
    }

    public void searchID(int id) {
        System.out.println(itemOrdered.get(id).toString());
    }

    public void searchTitle(String title) {
        for (DigitalVideoDisc item : itemOrdered) {
            if (item.isMatch(title)) {
                System.out.println(item.toString());
            }
        }
    }
}

