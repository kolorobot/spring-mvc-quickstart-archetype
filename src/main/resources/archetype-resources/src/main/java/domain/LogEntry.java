package ${package}.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "log_entry")
@NamedQuery(name = LogEntry.FIND_ALL, query = "select le from LogEntry le order by le.date desc")
public class LogEntry {
	
	public static final String FIND_ALL = "LogEntry.FindAll";
	
	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String message;

	public LogEntry() {

	}

	public LogEntry(Date date, String message) {
		this.date = date;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
