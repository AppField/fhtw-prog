package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

public class ShortTrackFormatter implements MyFormatter<Track> {

    public ShortTrackFormatter() {
    }

    public String header() {
        return String.format("%-10.10s (min:sec)", "Title");
    }

    public String format(Track track) {
        int hours = track.getDuration() / 60;
        int minutes = track.getDuration() % 60;
        return String.format("%-10.10s (%02d:%02d)", track.getTitle(), hours, minutes);
    }

    public String toString() {
        return "short format [Title (min:sec)]";
    }

    public String topSeparator() {
        String  header = this.header();
        String separator = "";
        for(int i = 0; i < header.length(); i++) {
            separator += "-";
        }
        return separator;
    }
}
