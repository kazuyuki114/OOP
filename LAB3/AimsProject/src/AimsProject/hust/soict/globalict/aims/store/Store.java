package AimsProject.hust.soict.globalict.aims.store;

import java.util.ArrayList;
import AimsProject.hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();
    public void addDVD(DigitalVideoDisc disc){
        if (disc != null){
            if(!itemsInStore.contains(disc)){
                itemsInStore.add(disc);
                System.out.println("The disc has been added to the store");
            } else {
                System.out.println("The disc exists in the store");
            }
        } else {
            System.out.println("The given disc is not available");
        }
    }
    public void removeDVD(DigitalVideoDisc disc){
        if (disc != null){
            if(itemsInStore.contains(disc)){
                itemsInStore.remove(disc);
                System.out.println("The disc has been removed from the store");
            } else {
                System.out.println("The disc does not exist in the store");
            }
        } else {
            System.out.println("The given disc is not available");
        }
    }
    public void printStore(){
        System.out.println("***********************************Store***********************************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsInStore.size(); i++){
            System.out.println(itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************************************");
    }
}
