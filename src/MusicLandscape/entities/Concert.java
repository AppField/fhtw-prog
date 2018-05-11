package MusicLandscape.entities;

public class Concert extends Event {

    private int nextIdx;
    private Track[] setList;


    public Concert() {
        this.setList = new Track[0];
        this.nextIdx = 0;
    }

    public boolean addTrack(Track track) {
        if (track != null) {

            if (this.setList.length <= this.nextIdx + 1) {
                this.ensureCapacity(this.setList.length + 1);
                this.setList[this.nextIdx] = track;
                this.nextIdx++;
            } else {
                this.setList[this.nextIdx] = track;
                this.nextIdx++;
            }

            return true;
        } else {
            return false;
        }
    }

    private void ensureCapacity(int length) {
        if (this.setList.length <= length) {

            Track[] tmpSetList = this.setList;

            this.setList = new Track[length];
            this.nextIdx = 0;
            for (int i = 0; i < tmpSetList.length; i++) {
                this.setList[this.nextIdx++] = tmpSetList[i];
            }
        }
    }

    public Track[] getSetList() {
        if (this.setList != null) {
            Track[] tmpSetList = new Track[this.setList.length];
            for (int i = 0; i < this.setList.length; i++) {
                tmpSetList[i] = new Track(this.setList[i]);
            }
            return tmpSetList;
        } else return new Track[0];
    }

    public void setSetList(Track[] tracks) {
        if (tracks != null) {

            Track[] newTracks = new Track[tracks.length];

            int idx = 0;
            for (Track track : tracks) {
                if (track != null) {
                    newTracks[idx++] = new Track(track);
                }
            }
            this.setList = newTracks;
        }
    }

    public void resetSetList() {
        this.setList = new Track[1];
        this.nextIdx = 0;
    }

    public int nrTracks() {
        int nr = 0;
        for (Track track : this.setList) {
            if (track != null) nr++;
        }
        return nr;
    }

    public int duration() {
        int duration = 0;
        for (Track track : this.setList) {
            duration += track.getDuration();
        }
        return duration;
    }

    public int impact() {

        int duration = 1;
        duration += this.duration() / (60 * 30);
        int attendees = this.getAttendees();

        return duration * attendees;
    }

    @Override
    public String toString() {

        String tmp = super.toString();

        int numberTracks = this.nrTracks();
        int duration = this.duration();
        String toAdd = String.format("\n%d tracks played, total duration %02d:%02d.", numberTracks, duration / (60 * 60), duration % (60 * 60) / 60);

        return tmp + toAdd;
    }
}
