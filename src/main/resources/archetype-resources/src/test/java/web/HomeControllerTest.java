package ${package}.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import ${package}.domain.*;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.*;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

	@InjectMocks
	private HomeController controller = new HomeController();

	@Mock
	private LogEntryRepository repositoryMock;

	@Test
	public void index() {
		// arrange
		Model model = new ExtendedModelMap();
		when(repositoryMock.findAll()).thenReturn(Collections.<LogEntry> emptyList());

		// act
		controller.index(model);

		// assert
		assertTrue(model.containsAttribute("logEntries"));
	}
}
