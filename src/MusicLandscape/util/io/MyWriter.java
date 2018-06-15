package MusicLandscape.util.io;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;
import MusicLandscape.util.formatters.CSVTrackFormatter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyWriter<T> {

    protected FileWriter out;
    private MyFormatter<T> theFormat;

    public MyWriter(FileWriter file, MyFormatter<T> theFormat) throws IllegalArgumentException {
        if (file == null) throw new IllegalArgumentException("expected non-null FileWriter");
        if (theFormat == null) throw new IllegalArgumentException("expected non-null MyFormatter");

        this.out = file;
        this.theFormat = theFormat;
    }

    public final boolean put(T t) throws IOException {

        try {

            String toAdd = this.theFormat.format(t);
            System.out.println("To Add");
            System.out.println(toAdd);

            this.out.write(toAdd);

            this.out.write('\n');

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void close() {
        try {
            this.out.close();
        } catch (Exception e) {

        }
    }

}
