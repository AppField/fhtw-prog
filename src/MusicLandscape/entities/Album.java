package MusicLandscape.entities;

public class Album extends Release {
    private class TrackListItem {

        private TrackListItem next;
        private Track track;

        public TrackListItem(Track t) {
            this.track = t;
        }
    }


    private TrackListItem trackListHead;

    public Album() {
        super();
        this.trackListHead = null;
    }

    public Album(Album orig) {
        super(orig);
//        this.trackListHead = orig.trackListHead;
    }

    public Album(String title, Artist artist, int year) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setYear(year);
    }

    public boolean addTrack(Track t) {
        if (t == null) return false;

        if (trackListHead == null) {
            this.trackListHead = new TrackListItem(t);
            return true;
        } else {
            TrackListItem item = this.trackListHead;
            while (item.next != null) {
                item = item.next;
            }
            item.next = new TrackListItem(t);
            return true;
        }
    }

    public Track removeTrack(int n) {
        TrackListItem item = this.trackListHead;
        TrackListItem removed;
        if (item == null) return null;
        if (n > this.nrTracks()) return null;
        if (n == 0) {
            removed = item;
            this.trackListHead = item.next;
            return removed.track;
        }
        int i = 0;
        while (i < n - 1 && item.next != null) {
            item = item.next;
            i++;
        }
        removed = item.next;
        item.next = removed.next;
        return removed.track;
    }

    public int nrTracks() {
        if (trackListHead == null) return 0;
        int counter = 1;
        TrackListItem item = this.trackListHead;
        while (item.next != null) {
            item = item.next;
            counter++;
        }
        return counter;
    }

    public Track[] getTracks() {
        if (this.trackListHead == null) return new Track[0];
        int counter = 0;
        TrackListItem item = this.trackListHead;
        while (item != null) {
            item = item.next;
            counter++;
        }
        Track[] trackList = new Track[counter];
        item = this.trackListHead;
        counter = 0;
        while (item != null) {
            trackList[counter] = item.track;
            item = item.next;
            counter++;
        }
        return trackList;
    }

    public int totalTime() {
        int total = 0;
        TrackListItem item = this.trackListHead;
        while (item != null) {
            if (item.track != null) total += item.track.getDuration();
            item = item.next;
        }
        return total;
    }

    @Override
    public String toString() {
        String toString = super.toString();
        toString += "\n[";

        TrackListItem item = this.trackListHead;
        while (item != null) {

            toString += item.track == null ? "[unknown title]" : "[" + item.track.getTitle() + "]";

            item = item.next;
        }

        toString += "]";
        return toString;
    }
}
