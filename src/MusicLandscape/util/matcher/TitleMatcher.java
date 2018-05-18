package MusicLandscape.util.matcher;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class TitleMatcher extends MyMatcher<Track> {

    private String pattern;

    public TitleMatcher(String pat){
        this.setPattern(pat);
    }

    public String getPattern() {
        return this.pattern;
    }

    @Override
    public boolean matches(Track track) {
        return track.getTitle().startsWith(this.pattern);
    }

    @Override
    public void setPattern(String pattern) {
        if(pattern == null) return;
        this.pattern = pattern;
    }

    public String toString() {
        return String.format("title starts with (%s)", this.pattern);
    }
}
