package MusicLandscape.entities;
import MusicLandscape.util.ConsoleScanable;
import java.util.Scanner;

public class Track implements ConsoleScanable {

    private int duration;
    private Artist performer;
    private String title;
    private Artist writer;
    private int year;


    public Track() {
        this.performer = new Artist();
        this.writer = new Artist();
        this.year = 0;
        this.duration = 0;
        this.year = 1900;
    }

    public Track(Track t) {
        this.duration = t.duration;
        this.performer = new Artist(t.performer);
        this.writer = new Artist(t.writer);
        this.title = t.title;
        this.year = t.year;
    }

    public Track(String title) {
        this();
        this.title = title;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration >= 0) {
            this.duration = duration;
        }
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        if (performer != null) {
            this.performer = performer;
        }
    }

    public String getTitle() {
        return title != null ? title : "unknown title";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getWriter() {
        return writer;
    }

    public void setWriter(Artist writer) {
        if (writer != null) {
           /* if (writer.getName() != null) {
                if (!writer.getName().trim().isEmpty()) {
                    this.writer = writer;
                }
            }*/
            this.writer = writer;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1900 && year <= 2999) {
            this.year = year;
        }
    }

    public boolean writerIsKnown() {
        return this.getWriter() != null && this.getWriter().getName() != null;
    }

    public String toString() {

        String title = String.format("%10.10s", this.title != null ? this.title : "unknown");
        String writer = String.format("%10.10s", this.writerIsKnown() ? this.writer.getName() : "unknown");
        String performer = String.format("%10.10s", this.performer != null ? this.performer.getName() != null ? this.performer.getName() : "unknown" : "unknown");
        int min = this.duration / 60;
        int sec = this.duration % 60;

        return String.format("%10s by %s performed by %s (%02d:%02d)", title, writer, performer, min, sec);
    }


    @Override
    public boolean scan() {
        boolean changed = false;
        Scanner sc = new Scanner(System.in);

        if (scanTitle(sc)) changed = true;
        if (scanDuration(sc)) changed = true;

        sc.close();
        return changed;
    }

    private boolean scanDuration(Scanner sc) {
        String input;
        do {
            System.out.printf("Current duration: %d\n", this.duration);
            System.out.printf("Enter duration (leave empty to keep): ");
            input = sc.nextLine();

            if (!input.isEmpty()) {
                if (input.matches("\\d+")) {
                    setDuration(Integer.parseInt(input));
                    return true;
                }
            } else {
                return false;
            }
        } while (true);
    }

    private boolean scanTitle(Scanner sc) {
        System.out.printf("Current Title: %s\n", this.title);
        System.out.printf("Enter title: (leave empty to keep): ");
        String input = sc.nextLine();

        if (!input.isEmpty()) {
            setTitle(input);
            return true;
        } else {
            return false;
        }
    }
}
