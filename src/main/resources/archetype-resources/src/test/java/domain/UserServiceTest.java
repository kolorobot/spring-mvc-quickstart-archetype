package ${package}.domain;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserService();

	@Mock
	private UserRepository userRepositoryMock;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldInitializeWithOneDemoUser() {
		// act
		userService.initialize();
		// assert
		verify(userRepositoryMock, times(1)).save(any(User.class));
	}

	@Test
	public void shouldThrowExceptionWhenUserNotFound() {
		// arrange
		thrown.expect(UsernameNotFoundException.class);
		thrown.expectMessage("user not found");

		when(userRepositoryMock.findByUsername("user")).thenReturn(null);
		// act
		userService.loadUserByUsername("user");
	}

	@Test
	public void shouldReturnUserDetails() {
		// arrange
		User demoUser = new User("user", "demo", "ROLE_USER");
		when(userRepositoryMock.findByUsername("user")).thenReturn(demoUser);

		// act
		UserDetails userDetails = userService.loadUserByUsername("user");

		// assert
		assertEquals(demoUser.getUsername(), userDetails.getUsername());
		assertEquals(demoUser.getPassword(), userDetails.getPassword());
		hasAuthority(userDetails, demoUser.getRole());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void hasAuthority(UserDetails userDetails, String role) {
		Collection authorities = userDetails.getAuthorities();
		assertThat(authorities, hasItem(new SimpleGrantedAuthority(role)));
	}
}
