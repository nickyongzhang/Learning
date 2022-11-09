package academy.learnprogramming;

import java.util.ArrayList;

public class Band extends Group{
    private ArrayList<RecordingArtist> recordingArtists;
    private String name;

    public Band(ArrayList<RecordingArtist> recordingArtists, String name) {
        this.recordingArtists = recordingArtists;
        this.name = name;
    }

    public ArrayList<RecordingArtist> getRecordingArtists() {
        return recordingArtists;
    }

    public String getName() {
        return name;
    }
}
