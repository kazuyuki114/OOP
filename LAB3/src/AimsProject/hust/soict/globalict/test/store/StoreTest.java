package AimsProject.hust.soict.globalict.test.store;

import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        DigitalVideoDisc disc1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc disc2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc disc3 = new DigitalVideoDisc(3,"Animation", "Aladin", 18.99f);
        store.addDVD(disc1);
        store.addDVD(disc2);
        store.addDVD(disc3);
        store.printStore();
    }
}
