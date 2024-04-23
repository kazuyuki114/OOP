package AimsProject.hust.soict.globalict.aims.media.disc;

public class DigitalVideoDisc extends Disc {


    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, director, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    // ToString method
    public String toString(){
        return "DVD - [" + this.getId() + "] - [" + this.getTitle() + "] - [" + this.getCategory() + "] - [" + this.getDirector() + "] - [" + this.getLength() + "]:[" + this.getCost() + "]$";
    }
    // isMatch method
    public boolean isMatch(String title){
        return this.getTitle().equals(title);
    }
}

