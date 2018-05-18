package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

public class MyTitleComparator extends MyTrackComparator {

    public MyTitleComparator() {

    }

    public int compare(Track t1, Track t2) {
        String title1 = t1.getTitle();
        String title2 = t2.getTitle();
        
        return title1.compareTo(title2);
    }

}
