package MusicLandscape.entities;

import MusicLandscape.Date;
import MusicLandscape.Venue;

public class TVShow extends Event {

    private String name;
    private int viewers;

    public TVShow() {
        super();
        this.name = null;
        this.viewers = 0;
    }

    public TVShow(Event event) {
        this();
        this.setAttendees(event.getAttendees());
        this.setDescription(event.getDescription());
        this.setArtist(new Artist(event.getArtist()));
        this.setDate(new Date(event.getDate()));
        this.setVenue(new Venue(event.getVenue()));
    }

    public TVShow(TVShow tvs) {
        this.name = tvs.name;
        this.viewers = tvs.viewers;
        this.setAttendees(tvs.getAttendees());
        this.setDescription(tvs.getDescription());
        this.setArtist(new Artist(tvs.getArtist()));
        this.setDate(new Date(tvs.getDate()));
        this.setVenue(new Venue(tvs.getVenue()));
    }

    public String toString() {
        String artist = this.getArtist().getName();
        String showName = this.name;

        String date = this.getDate().toString();
        String description = this.getDescription();

        int audience = this.viewers + this.getAttendees();
        int impact = this.impact();

        return String.format("%s @ %s on %s\n%s\n(%d attending (%d))", artist, showName, date, description, audience, impact);
    }

    @Override
    public int impact() {
        int audience = this.viewers + this.getAttendees();
        return audience * 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null)
            this.name = name.trim();
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        if (viewers >= 0) {
            this.viewers = viewers;
        }
    }


}
