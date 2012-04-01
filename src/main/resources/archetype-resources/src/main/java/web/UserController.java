package ${package}.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
@PreAuthorize("isAuthenticated()")
public class UserController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "user/index";
	}
}
