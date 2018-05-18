package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

import java.util.Comparator;

public class TitleComparator implements Comparator<Track> {

    public TitleComparator() {
    }

    public int compare(Track o1, Track o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

    public String toString() {
        return "by title";
    }

}
