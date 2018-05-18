package MusicLandscape;

import MusicLandscape.entities.Album;
import MusicLandscape.entities.Track;
import MusicLandscape.util.formatters.MyShortTrackFormatter;
import bwi.prog.utils.TextIO;

public class DemoApp {

    public static void main(String[] args) {

        MyShortTrackFormatter shortTrackFormatter = new MyShortTrackFormatter();


        Album album = new Album();

        Track track = new Track();
        TextIO.putln("Enter track data");
        track.scan();

        TextIO.putln(track.toString());

        TextIO.putln("Tracks: " + album.nrTracks());
        album.addTrack(track);
        TextIO.putln("Added Track: " + album.nrTracks());


        TextIO.putln("Album String:");
        TextIO.putln(album.toString());


        album.removeTrack(0);
        TextIO.putln("Removed Tracks: " + album.nrTracks());


        TextIO.putln(album.toString());

        TextIO.putln(shortTrackFormatter.format(track));

    }

}
