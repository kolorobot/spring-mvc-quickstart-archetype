package ${package}.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AboutController {

	@ModelAttribute("module")
	String module() {
		return "about";
	}

	@GetMapping("/about")
	String about() {
		return "home/about";
	}
}
