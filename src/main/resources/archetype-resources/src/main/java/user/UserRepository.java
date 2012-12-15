package ${package}.user;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(User user) {
		entityManager.persist(user);
	}
	
	public User findByUsername(String username) {
		try {
			return entityManager.createNamedQuery(User.FIND_BY_USERNAME, User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	
}
