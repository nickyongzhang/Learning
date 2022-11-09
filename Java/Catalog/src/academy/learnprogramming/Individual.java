package academy.learnprogramming;

public abstract class Individual extends Creator{
    private String firstName;
    private String lastName;

    public Individual(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
