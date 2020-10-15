package model;

public class Person {

    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getInitials() {
        String firstInitial = Character.toString(firstname.charAt(0));
        String lastInitial = Character.toString(lastname.charAt(0));

        return firstInitial + lastInitial;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
