package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

public class CSVTrackFormatter implements MyFormatter<Track> {

    public CSVTrackFormatter() {
    }


    public String header() {
        return "Title,Writer,Performer,duration,year";
    }

    public String topSeparator() {
        return " ";
    }

    public String format(Track track) {
        return String.format("%s, %s, %s, %d, %d", track.getTitle(),
                track.getWriter(), track.getPerformer(), track.getDuration(), track.getYear());
    }

    public String toString() {
        return "CSV format [Title, Writer, Performer, duration, year]";
    }

}
