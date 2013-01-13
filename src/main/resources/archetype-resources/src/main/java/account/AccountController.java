package ${package}.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Secured("ROLE_USER")
public class AccountController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountRepository userRepository;
	
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String index(UserDetails userDetails, Model model) {
		LOG.info(userDetails.toString());
		return "account/index";
	}
	
	@RequestMapping(value = "account.json", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Account jsonGetAccount(UserDetails userDetails) {
		return userRepository.findByUsername(userDetails.getUsername());
	}
}
