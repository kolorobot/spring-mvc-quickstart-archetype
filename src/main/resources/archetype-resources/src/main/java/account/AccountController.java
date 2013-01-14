package ${package}.account;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Secured("ROLE_USER")
public class AccountController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountRepository userRepository;
	
	@RequestMapping(value = "account/current", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Account accounts(UserDetails userDetails) {
		LOG.info(userDetails.toString());
		return userRepository.findByUsername(userDetails.getUsername());
	}
}
