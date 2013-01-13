package ${package}.account;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

public class UserService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@PostConstruct	
	protected void initialize() {
		accountRepository.save(new Account("user", "demo", "ROLE_USER"));
		accountRepository.save(new Account("admin", "admin", "ROLE_ADMIN"));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority(account.getRole());
		return new User(account.getUsername(), account.getPassword(), Collections.singleton(authority));
	}

}
