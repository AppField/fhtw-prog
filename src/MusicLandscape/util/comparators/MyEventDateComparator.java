package MusicLandscape.util.comparators;

import MusicLandscape.Date;
import MusicLandscape.entities.Event;

public class MyEventDateComparator extends MyEventComparator {


    public MyEventDateComparator() {

    }

    @Override
    public int compare(Event e1, Event e2) {
        if(e1 == null && e2== null) return 0;
        if(e1 == null) return -1;
        if(e2 == null) return 1;

        Date date1 = e1.getDate();
        Date date2 = e2.getDate();

        if(date1 == null && date2 == null) return 0;
        if(date1 == null) return -1;
        if(date2 == null) return 1;



        return date1.compareTo(date2);

    }

}
