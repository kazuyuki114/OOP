package AimsProject.hust.soict.globalict.aims.media.comparator;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost  implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int checkTitle = title1.compareTo(title2);
        if (checkTitle != 0){
            return checkTitle;
        } else {
            Float cost1 = o1.getCost();
            Float cost2 = o2.getCost();
            return cost2.compareTo(cost1);
        }
    }

}
