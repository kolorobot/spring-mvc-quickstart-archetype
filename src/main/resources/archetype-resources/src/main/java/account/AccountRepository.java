package ${package}.account;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class AccountRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Account save(Account account) {
		entityManager.persist(account);
		return account;
	}
	
	public Account findByUsername(String username) {
		try {
			return entityManager.createNamedQuery(Account.FIND_BY_USERNAME, Account.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	
}
