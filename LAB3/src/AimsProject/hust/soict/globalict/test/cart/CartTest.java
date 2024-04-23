package AimsProject.hust.soict.globalict.test.cart;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

public class CartTest {
    public static void main(String[] args) {
        DigitalVideoDisc disc1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc disc2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc disc3 = new DigitalVideoDisc(3,"Animation", "Aladin", 18.99f);

        Store store = new Store();
        store.addDVD(disc1);
        store.addDVD(disc2);
        store.addDVD(disc3);

        Cart cart = new Cart();
        cart.addDigitalVideoDisc(disc1, store);
        cart.addDigitalVideoDisc(disc2, store);
        cart.addDigitalVideoDisc(disc3, store);
        cart.removeDigitalVideoDisc(disc3);
        cart.printCart();
        cart.searchTitle("The Lion King");
    }
}

