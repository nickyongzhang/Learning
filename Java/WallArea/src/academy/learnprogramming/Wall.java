package academy.learnprogramming;

public class Wall {
    private double width;
    private double height;

    public Wall(double width, double height) {
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
    }

    public Wall() {
        this(0, 0);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = Math.max(0, width);
    }

    public void setHeight(double height) {
        this.height = Math.max(0, height);
    }

    public double getArea() {
        return this.height * this.width;
    }
}
