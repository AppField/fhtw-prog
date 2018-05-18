package MusicLandscape.util.matcher;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class DurationMatcher extends MyMatcher<Track> {

    private int lower;
    private int upper;

    public DurationMatcher() {
        this.upper = 2147483647;
    }

    public DurationMatcher(String pat) {
        this.setPattern(pat);
    }


    @Override
    public boolean matches(Track track) {
        return track.getDuration() >= lower && track.getDuration() <= upper;
    }

    @Override
    public void setPattern(String pat) {
        pat = pat.trim();
        String[] pattern = pat.split("\\s+");

        try {
            if (pattern.length == 1) {
                int lower = Integer.parseInt(pattern[0]);
                if (lower <= this.upper) this.lower = lower;
            } else {
                int lower = Integer.parseInt(pattern[0]);
                int upper = Integer.parseInt(pattern[1]);

//                if (lower <= upper) {
                this.lower = lower;
                if (upper >= lower) {
                    this.upper = upper;
                }
            }
        } catch (NumberFormatException exception) {

        }
    }

    @Override
    public String getPattern() {
        return this.lower + " " + this.upper;
    }

    @Override
    public String toString() {
        return "duration in range (" + this.getPattern() + ")";
    }
}


