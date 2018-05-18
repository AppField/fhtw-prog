package MusicLandscape.entities;

public abstract class Release {

    private Artist artist;
    private String title;
    private int year;

    public Release() {
        this.artist = new Artist();
        this.year = 1900;
        this.title = null;
    }

    public Release(Release orig) {
        this.artist = new Artist(orig.artist);
        this.title = orig.title;
        this.year = orig.year;
    }

    public Release(String title,
                   Artist artist,
                   int year) {
        this.artist = artist;
        this.year = year;
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title == null ? "null" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 0) this.year = year;
    }

    public abstract int totalTime();

    public String toString() {

        String artist = this.artist == null ? "unknown" : this.artist.toString() == null ? "unknown" : this.artist.toString();
        String title = this.title == null ? "unknown" : this.title;
        String year = this.year == 0 ? "unknown" : Integer.toString(this.year);
        String totalTime = Integer.toString(this.totalTime());

        return String.format("%s-%s-%s-%s", title, artist, year, totalTime);

    }
}
