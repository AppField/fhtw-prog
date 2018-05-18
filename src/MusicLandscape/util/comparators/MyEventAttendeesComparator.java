package MusicLandscape.util.comparators;

import MusicLandscape.entities.Event;

public class MyEventAttendeesComparator extends MyEventComparator {

    public MyEventAttendeesComparator() {

    }

    public int compare(Event e1, Event e2) {
        if(e1 == null && e2 == null) return 0;
        if(e1 == null) return -1;
        if (e2 == null) return 1;

        int attendees1 = e1.getAttendees();
        int attendees2 = e2.getAttendees();


        return Integer.compare(attendees1, attendees2);
    }
}
