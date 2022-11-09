package academy.learnprogramming;

public abstract class Item {
    private Creator creator;
    private String title;
    private int yearCreated;

    public Item(Creator creator, String title, int yearCreated) {
        this.creator = creator;
        this.title = title;
        this.yearCreated = yearCreated;
    }

    public Creator getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public int getYearCreated() {
        return yearCreated;
    }
}
