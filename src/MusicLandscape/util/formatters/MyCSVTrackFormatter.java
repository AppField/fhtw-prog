package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;

public class MyCSVTrackFormatter extends MyTrackFormatter {

    public MyCSVTrackFormatter() {
    }


    public String format(Track track) {
        return String.format("%s,%s,%s,%d,%d;", track.getTitle(),
                track.getPerformer(), track.getWriter(), track.getYear(), track.getDuration());
    }


}
