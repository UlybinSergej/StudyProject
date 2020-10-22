package task3.task1;


public class Person {
    private String firstName;
    private String lastName;
    private String sex;

    public Person(String firstName, String lastName, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        if (sex.equals("f")) {
            return firstName + " " + lastName + "а";
        } else {
            return firstName + " " + lastName;
        }
    }
}
