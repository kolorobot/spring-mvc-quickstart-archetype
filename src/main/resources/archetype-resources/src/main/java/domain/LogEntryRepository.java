package ${package}.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class LogEntryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createLogEntry(String message) {
		entityManager.persist(new LogEntry(new Date(), message));
	}
	
	public List<LogEntry> findAll() {
		return entityManager.createNamedQuery(LogEntry.FIND_ALL, LogEntry.class).getResultList();
	}
}
