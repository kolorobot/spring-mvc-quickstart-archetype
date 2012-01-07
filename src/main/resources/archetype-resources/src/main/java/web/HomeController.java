package ${package}.web;

import ${package}.domain.*;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
public class HomeController {
	
	@Inject
	private LogEntryRepository repo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		repo.createLogEntry("entering index...");
		model.addAttribute("logEntries", repo.findAll());
		return "index";
	}
}
