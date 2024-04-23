package AimsProject.hust.soict.globalict.aims.media.disc;

import AimsProject.hust.soict.globalict.aims.media.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("***Can not play this track***");
        }
    }
    public String toString(){
        return "[ "+ this.getTitle() + ", " + this.getLength() + " ]";
    }
}
