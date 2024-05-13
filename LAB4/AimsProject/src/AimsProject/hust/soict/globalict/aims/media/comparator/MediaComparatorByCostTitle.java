package AimsProject.hust.soict.globalict.aims.media.comparator;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        Float cost1 = o1.getCost();
        Float cost2 = o2.getCost();
        int checkCost = cost1.compareTo(cost2);
        if (checkCost != 0){
            return checkCost;
        } else {
            String title1 = o1.getTitle();
            String title2 = o2.getTitle();
            return title1.compareTo(title2);
        }
    }
}
