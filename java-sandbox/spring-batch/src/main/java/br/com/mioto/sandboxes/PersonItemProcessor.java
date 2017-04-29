package br.com.mioto.sandboxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

/**
 * The Class PersonItemProcessor.
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    /* (non-Javadoc)
     * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
     */
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
