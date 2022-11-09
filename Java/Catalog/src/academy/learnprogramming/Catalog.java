package academy.learnprogramming;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Item> library;

    public Catalog(ArrayList<Item> library) {
        this.library = library;
    }

    public Catalog() {
        this.library = new ArrayList<>();
    }

    public void add(Item item) {
        library.add(item);
    }

    public void remove(Item item) {
        library.remove(item);
    }

    public ArrayList<Item> search(String keyword) {
        ArrayList<Item> results = new ArrayList<>();
        for (Item item:library) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public ArrayList<Book> search(Author author) {
        ArrayList<Book> results = new ArrayList<>();
        for (Item item:library) {
            if (item instanceof Book && item.getCreator().equals(author)) {
                Book book = (Book) item;
                results.add(book);
            }
        }
        return results;
    }

    public ArrayList<Music> search(RecordingArtist artist) {
        ArrayList<Music> results = new ArrayList<>();
        for (Item item:library) {
            if (item instanceof Music) {
                Music music = (Music) item;
                if (music.getCreator() instanceof RecordingArtist
                        && music.getCreator().equals(artist)) {
                    results.add(music);
                } else if (music.getCreator() instanceof Band) {
                    Band band = (Band) music.getCreator();
                    if (band.getRecordingArtists().contains(artist)) {
                        results.add(music);
                    }
                }
            }
        }
        return results;
    }
}
