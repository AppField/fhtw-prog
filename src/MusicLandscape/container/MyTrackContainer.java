package MusicLandscape.container;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

import java.util.*;

public class MyTrackContainer {

    private List<Track> selection;
    private Set<Track> tracks;

    public MyTrackContainer() {
        this.selection = new LinkedList<>();
        this.tracks = new HashSet<>();
    }

    public MyTrackContainer(Iterable<Track> t) {
        this();
        t.forEach(track -> {
            this.tracks.add(track);
            this.selection.add(track);
        });
    }

    public MyTrackContainer(Track[] tracks) {
        this();
        for (Track track : tracks) {
            this.tracks.add(track);
            this.selection.add(track);
        }
    }

    public void sort(Comparator<Track> theComp, boolean asc) {
        this.selection.sort(new Comparator<Track>() {
            @Override
            public int compare(Track track, Track t1) {
                return track.getTitle().compareTo(t1.getTitle());
            }
        });
    }

    public int filter(MyMatcher<Track> matcher) {
        List<Track> filteredList = new ArrayList<>();
        int removed = 0;
        this.selection.forEach(track -> {
            if (matcher.matches(track)) filteredList.add(track);
        });

        removed = this.selection.size() - filteredList.size();
        this.selection = filteredList;

        return removed;

    }

    public void reset() {
        this.selection.clear();
        this.selection.addAll(this.tracks);
    }

    public int remove() {
        int removed = this.selection.size();
        this.selection.forEach(track -> {
            this.tracks.remove(track);
        });
        this.reset();
        return removed;
    }

    public int addAll(Track[] tracks) {
        int oldSize = this.tracks.size();
        this.tracks.addAll(Arrays.asList(tracks));
        return this.tracks.size() - oldSize;
    }

    public int size() {
        return this.tracks.size();
    }

    public Track[] selection() {
        return this.selection.toArray(new Track[this.selection.size()]);
    }

    public boolean add(Track track) {
        if (track == null) return false;
        if (this.tracks.contains(track)) return false;

        this.tracks.add(track);
        return true;
    }

}
