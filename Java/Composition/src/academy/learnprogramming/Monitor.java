package academy.learnprogramming;

public class Monitor {
    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResolutions;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolutions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolutions = nativeResolutions;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Draw pixel at "+x+" and "+y+" in color "+color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolutions() {
        return nativeResolutions;
    }
}
