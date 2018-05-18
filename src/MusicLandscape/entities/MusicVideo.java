package MusicLandscape.entities;

public class MusicVideo extends Release {

    private Track track;

    public MusicVideo() {}

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public int totalTime() {
        return this.track != null ? this.track.getDuration() : 0;
    }

    @Override
    public String toString() {
        return super.toString() + "-(Video)";
    }
}
