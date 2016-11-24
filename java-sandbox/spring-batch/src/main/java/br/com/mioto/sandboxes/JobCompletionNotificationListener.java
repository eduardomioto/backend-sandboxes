package br.com.mioto.sandboxes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * The listener interface for receiving jobCompletionNotification events.
 * The class that is interested in processing a jobCompletionNotification
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addJobCompletionNotificationListener<code> method. When
 * the jobCompletionNotification event occurs, that object's appropriate
 * method is invoked.
 *
 * @see JobCompletionNotificationEvent
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	/** The jdbc template. */
	private final JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new job completion notification listener.
	 *
	 * @param jdbcTemplate the jdbc template
	 */
	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.listener.JobExecutionListenerSupport#afterJob(org.springframework.batch.core.JobExecution)
	 */
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM people", new RowMapper<Person>() {
				@Override
				public Person mapRow(ResultSet rs, int row) throws SQLException {
					return new Person(rs.getString(1), rs.getString(2));
				}
			});

			for (Person person : results) {
				log.info("Found <" + person + "> in the database.");
			}

		}
	}
}
