package br.com.mioto.sandboxes;

/**
 * The Class Person.
 */
public class Person {
    
    /** The last name. */
    private String lastName;
    
    /** The first name. */
    private String firstName;

    /**
     * Instantiates a new person.
     */
    public Person() {

    }

    /**
     * Instantiates a new person.
     *
     * @param firstName the first name
     * @param lastName the last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}