package academy.learnprogramming;

public class Car extends Vehicle{
    private int wheels;
    private int doors;
    private int gears;
    private boolean isMannual;

    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isMannual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isMannual = isMannual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.changeGear() called: changed to "+this.currentGear+" gear.");
    }

    public void changeVelocity(int speed, int direction) {
        System.out.println("Car.changeVelocity(): Velocity: "+speed+"; Direction: "+direction);
        move(speed, direction);
    }
}
