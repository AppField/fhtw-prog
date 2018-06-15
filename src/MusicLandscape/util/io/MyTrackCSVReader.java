package MusicLandscape.util.io;

import MusicLandscape.entities.Artist;
import MusicLandscape.entities.Track;
import MusicLandscape.util.comparators.DurationComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;

public class MyTrackCSVReader extends MyReader<Track> {

    private static int DURATION = 3;
    private static int PERFORMER = 2;
    private static int TITLE =0;
    private static int WRITER = 1;
    private static int YEAR = 4;

    public MyTrackCSVReader(BufferedReader in) {
        super(in);
    }

    public Track get() {

        try {
            Track track = new Track();
//            this.in = new BufferedReader(new FileReader("./mytracks.csv"));
            for(String line = this.in.readLine(); line != null; line = this.in.readLine()) {
                System.out.println(line);
                String[] split = line.split(",");
                for(int i = 0; i < split.length; i++)
                    split[i] = split[i].trim();

                track.setTitle(split[TITLE]);
                track.setWriter(new Artist(split[WRITER]));
                track.setPerformer(new Artist(split[PERFORMER]));
                track.setDuration(Integer.parseInt(split[DURATION]));
                track.setYear(Integer.parseInt(split[YEAR]));
                return track;

            }
        } catch(IOException e) {
            System.out.println("Error reading.");
//            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Error parsing.");
//            e.printStackTrace();
        }

        return null;
    }

}
