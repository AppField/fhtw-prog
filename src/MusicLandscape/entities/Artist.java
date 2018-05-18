package MusicLandscape.entities;

public class Artist implements Comparable<Artist>{

    private String name;

    public Artist() {
        this.name = "unknown";
    }

    public Artist(Artist a) {
        this.name = a.name;
    }

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            name = name.trim();
            if (!name.isEmpty()) {
                this.name = name;
            }
        }
    }

    public String toString() {
        return (this.name == null) ? "unknown" : this.name;
    }

    @Override
    public int compareTo(Artist artist) {
        return this.getName().compareTo(artist.getName());
    }
}
