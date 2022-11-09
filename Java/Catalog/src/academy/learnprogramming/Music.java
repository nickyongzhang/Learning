package academy.learnprogramming;

public class Music extends Item {
    public Music(RecordingArtist recordingArtist, String title, int yearCreated) {
        super(recordingArtist, title, yearCreated);
    }

    public Music(Band band, String title, int yearCreated) {
        super(band, title, yearCreated);
    }
}
